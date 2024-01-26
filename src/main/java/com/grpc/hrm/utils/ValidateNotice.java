package com.grpc.hrm.utils;

import com.ks.proto.notice.NoticeRequest;

public class ValidateNotice {

    public static void validateNotice(NoticeRequest notice){
        if(notice.getTitle().isEmpty() || notice.getContent().isEmpty()){
            throw new IllegalArgumentException("Fields should not be empty");
        }
    }


    public static void validateId(String id) {
        if(id.isEmpty()){
            throw new IllegalArgumentException("noticeId should not be empty");
        }
    }
}
