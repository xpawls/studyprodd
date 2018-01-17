package com.spring81.bbs.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebConstants {
    public static final String SESSION_NAME = "user";
    public static final String NOT_LOGIN = "로그인되지 않았습니다";
    public static final String ERROR_PASSWORD = "비밀번호가 틀립니다";
    public static final String MSG_FAIL_CHANGE_PASSWORD = "비밀번호 변경을 실패하였습니다.";
    public static final String MSG_FAIL_UPDATE_TABLE = "테이블 업데이트 실패";
    public static final String UPDATE_FAIL    = "DB 업데이트 실패";
    public static final String MSG_FAIL_INSERT_TABLE = "테이블 삽입 실패";
    public static final String MSG_FAIL_DELETE_TABLE = "테이블 삭제 실패";
    private Logger logger = LoggerFactory.getLogger(this.getClass());
}
