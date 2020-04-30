package org.bobo.silence.common.util;

import java.util.concurrent.TimeUnit;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

public class RedisLock {
	private final static long ACCQUIRE_LOCK_TIMEOUT_IN_MS = 10 * 1000;// 请求超时时间
	private final static int EXPIRE_IN_SECOND = 5;// 锁失效时间
	private final static long WAIT_INTERVAL_IN_MS = 100;// 请求间隔
	private static RedisLock lock;
	private JedisPool jedisPool;

	private RedisLock(JedisPool pool) {
		this.jedisPool = pool;
	}

	public static RedisLock getInstance(JedisPool pool) {
		if (lock == null) {
			lock = new RedisLock(pool);
		}
		return lock;
	}

	public void lock(final String redisKey, final String uuid) {
		Jedis resource = null;
		try {
			long now = System.currentTimeMillis();
			resource = jedisPool.getResource();
			long timeoutAt = now + ACCQUIRE_LOCK_TIMEOUT_IN_MS;
			boolean flag = false;
			while (true) {
				// String uuid=UUID.randomUUID().toString();
				long ret = resource.setnx(redisKey, uuid);
				if (ret == 1) {// 已获取锁
					flag = true;
					resource.expire(redisKey, EXPIRE_IN_SECOND);
					break;
				}
				if (timeoutAt < now) {
					break;
				}
				TimeUnit.NANOSECONDS.sleep(WAIT_INTERVAL_IN_MS);
			}
			if (!flag) {
				throw new RuntimeException("canot acquire lock now ...");
			}
		} catch (JedisException je) {
			je.printStackTrace();
			if (resource != null) {
				jedisPool.returnBrokenResource(resource);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (resource != null) {
				jedisPool.returnResource(resource);
			}
		}
	}

	public boolean unlock(final String redisKey, final String uuid) {
		Jedis resource = null;
		try {
			resource = jedisPool.getResource();
			if (resource.get(redisKey).equals(uuid))
				resource.del(redisKey);
			return true;
		} catch (JedisException je) {
			je.printStackTrace();
			if (resource != null) {
				jedisPool.returnBrokenResource(resource);
			}
			return false;
		} catch (Exception e) {
			return false;
		} finally {
			if (resource != null) {
				jedisPool.returnResource(resource);
			}
		}
	}
}
