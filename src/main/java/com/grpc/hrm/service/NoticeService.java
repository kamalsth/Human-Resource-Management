package com.grpc.hrm.service;

import com.grpc.hrm.model.Notice;

import java.util.List;

public interface NoticeService {
    Notice addNotice(Notice notice);

    List<Notice> getAllNotice(int pageNumber, int pageSize);

    Notice updateNotice(String noticeId, Notice notice);

    void deleteNotice(String noticeId);
}
