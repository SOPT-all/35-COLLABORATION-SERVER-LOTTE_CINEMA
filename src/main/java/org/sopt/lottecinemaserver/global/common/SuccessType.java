package org.sopt.lottecinemaserver.global.common;

import org.springframework.http.HttpStatus;

public enum SuccessType {
    /**
     * 200 OK
     */
    PROCESS_SUCCESS(HttpStatus.OK, "OK"),
    GET_REGION_LIST_SUCCESS(HttpStatus.OK, "지역 리스트가 성공적으로 조회되었습니다."),
    GET_THEATER_LIST_SUCCESS(HttpStatus.OK, "영화관 리스트가 성공적으로 조회되었습니다.");
    private final HttpStatus httpStatus;
    private final String message;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    private SuccessType(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
