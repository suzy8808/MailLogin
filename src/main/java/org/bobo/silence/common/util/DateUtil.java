package org.bobo.silence.common.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static final Calendar calendar = Calendar.getInstance();

	public static Date now() {
		return new Date();
	}

	public static Date addDay(Date date, int day) {
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}

}
