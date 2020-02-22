package org.bobo.silence.bean;

import java.util.Date;

public class BlackList {
    private String blId;

    private String masterId;

    private String followId;

    private Date createTime;

    private Date updateTime;

    public String getBlId() {
        return blId;
    }

    public void setBlId(String blId) {
        this.blId = blId == null ? null : blId.trim();
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId == null ? null : masterId.trim();
    }

    public String getFollowId() {
        return followId;
    }

    public void setFollowId(String followId) {
        this.followId = followId == null ? null : followId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}