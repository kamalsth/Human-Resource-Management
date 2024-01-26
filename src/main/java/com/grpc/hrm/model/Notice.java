package com.grpc.hrm.model;

public class Notice {
    private String noticeId;
    private String title;
    private String content;
    private long addedAt;

    public Notice(String noticeId, String title, String content, long addedAt) {
        this.noticeId = noticeId;
        this.title = title;
        this.content = content;
        this.addedAt = addedAt;
    }


    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(long addedAt) {
        this.addedAt = addedAt;
    }
}
