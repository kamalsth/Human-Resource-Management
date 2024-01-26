package com.grpc.hrm.service.serviceimpl;

import com.grpc.hrm.model.Notice;
import com.grpc.hrm.repository.NoticeRepository;
import com.grpc.hrm.service.NoticeService;
import com.grpc.hrm.utils.GenerateUUID;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }


    @Override
    public Notice addNotice(Notice notice) {
        notice.setNoticeId(GenerateUUID.generateID());
        notice.setCreatedAt(System.currentTimeMillis());
        notice.setUpdatedAt(System.currentTimeMillis());
        return noticeRepository.addNotice(notice);
    }

    @Override
    public List<Notice> getAllNotice(int pageNumber, int pageSize) {
        return noticeRepository.getAllNotice(pageNumber, pageSize);
    }

    @Override
    public Notice updateNotice(String noticeId, Notice notice) {
        Notice exNotice = noticeRepository.getNoticeById(noticeId);
        if (exNotice == null) {
            throw new RuntimeException("Notice not found for id : " + noticeId);
        }
        notice.setUpdatedAt(System.currentTimeMillis());
        return noticeRepository.updateNotice(noticeId, notice);
    }

    @Override
    public String deleteNotice(String noticeId) {
        Notice exNotice = noticeRepository.getNoticeById(noticeId);
        if (exNotice == null) {
            throw new RuntimeException("Notice not found for id : " + noticeId);
        }
        noticeRepository.deleteNotice(noticeId);
        return "Notice deleted successfully!!";
    }


}
