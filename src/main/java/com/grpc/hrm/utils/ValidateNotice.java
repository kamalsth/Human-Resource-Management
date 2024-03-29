package com.grpc.hrm.utils;

import com.ks.proto.notice.NoticeRequest;

public class ValidateNotice {

    public static void validateNotice(NoticeRequest notice){
        if (notice.getTitle().isEmpty()){
            throw new IllegalArgumentException("Title should not be empty");

        } else if (notice.getContent().isEmpty()){
            throw new IllegalArgumentException("Content should not be empty");
        }
    }


    public static void validateId(String id) {
        if(id.isEmpty()){
            throw new IllegalArgumentException("noticeId should not be empty");
        }
    }
}
