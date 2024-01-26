package com.grpc.hrm.repository;

import com.grpc.hrm.model.Notice;

import java.util.List;

public interface NoticeRepository {
    Notice addNotice(Notice notice);

    List<Notice> getAllNotice(int pageNumber, int pageSize);


    Notice updateNotice(String noticeId, Notice notice);

    Notice getNoticeById(String noticeId);

    void deleteNotice(String noticeId);
}
