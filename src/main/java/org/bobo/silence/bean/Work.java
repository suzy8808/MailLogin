package org.bobo.silence.bean;

import java.util.Date;

public class Work {
    private String workId;

    private String workName;

    private Integer typeId;

    private String userId;

    private String desc;

    private String cover;

    private String md;

    private Long watchSum;

    private Long commentSum;

    private Long forwardSum;

    private Long likeSum;

    private Long dislikeSum;

    private Long coinSum;

    private Long collectSum;

    private Long reportSum;

    private Integer deleteFlag;

    private Integer state;

    private String workPath;

    private String tag;

    private Date createTime;

    private Date updateTime;

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName == null ? null : workName.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md == null ? null : md.trim();
    }

    public Long getWatchSum() {
        return watchSum;
    }

    public void setWatchSum(Long watchSum) {
        this.watchSum = watchSum;
    }

    public Long getCommentSum() {
        return commentSum;
    }

    public void setCommentSum(Long commentSum) {
        this.commentSum = commentSum;
    }

    public Long getForwardSum() {
        return forwardSum;
    }

    public void setForwardSum(Long forwardSum) {
        this.forwardSum = forwardSum;
    }

    public Long getLikeSum() {
        return likeSum;
    }

    public void setLikeSum(Long likeSum) {
        this.likeSum = likeSum;
    }

    public Long getDislikeSum() {
        return dislikeSum;
    }

    public void setDislikeSum(Long dislikeSum) {
        this.dislikeSum = dislikeSum;
    }

    public Long getCoinSum() {
        return coinSum;
    }

    public void setCoinSum(Long coinSum) {
        this.coinSum = coinSum;
    }

    public Long getCollectSum() {
        return collectSum;
    }

    public void setCollectSum(Long collectSum) {
        this.collectSum = collectSum;
    }

    public Long getReportSum() {
        return reportSum;
    }

    public void setReportSum(Long reportSum) {
        this.reportSum = reportSum;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getWorkPath() {
        return workPath;
    }

    public void setWorkPath(String workPath) {
        this.workPath = workPath == null ? null : workPath.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
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