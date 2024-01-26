package com.grpc.hrm.facade;

import com.grpc.hrm.mapper.MapperConfig;
import com.grpc.hrm.model.Notice;
import com.grpc.hrm.service.NoticeService;
import com.ks.proto.common.StatusResponse;
import com.ks.proto.notice.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeFacade {

    private final NoticeService noticeService;

    public NoticeFacade(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    public NoticeResponse saveNotice(NoticeRequest request) {
        Notice notice = MapperConfig.INSTANCE.mapNoticeRequestToNotice(request);
        return MapperConfig.INSTANCE.mapNoticeToNoticeResponse(noticeService.addNotice(notice));
    }

    public NoticeListResponse getAllNotice(NoticeListRequest request) {
        List<Notice> notices = noticeService.getAllNotice(request.getPageNumber(), request.getPageSize());
        List<NoticeResponse> noticeResponseList = notices.stream().map(MapperConfig.INSTANCE::mapNoticeToNoticeResponse).toList();
        return NoticeListResponse.newBuilder()
                .addAllNotices(noticeResponseList)
                .build();
    }

    public NoticeResponse updateNotice(NoticeRequest request) {
        Notice notice = MapperConfig.INSTANCE.mapNoticeRequestToNotice(request);
        return MapperConfig.INSTANCE.mapNoticeToNoticeResponse(noticeService.updateNotice(request.getNoticeId(), notice));
    }

    public StatusResponse deleteNotice(String noticeId) {
        noticeService.deleteNotice(noticeId);
        return StatusResponse.newBuilder()
                .setStatus("Notice deleted successfully!!")
                .build();
    }


}
