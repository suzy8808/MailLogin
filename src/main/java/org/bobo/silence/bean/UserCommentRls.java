package org.bobo.silence.bean;

import java.util.Date;

public class UserCommentRls {
    private String ucRlsId;

    private String userId;

    private String commentId;

    private Integer like;

    private Integer dislike;

    private Integer report;

    private Date createTime;

    private Date updateTime;

    public String getUcRlsId() {
        return ucRlsId;
    }

    public void setUcRlsId(String ucRlsId) {
        this.ucRlsId = ucRlsId == null ? null : ucRlsId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    public Integer getReport() {
        return report;
    }

    public void setReport(Integer report) {
        this.report = report;
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