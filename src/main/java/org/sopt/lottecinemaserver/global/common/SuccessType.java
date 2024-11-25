package org.sopt.lottecinemaserver.global.common;

import org.springframework.http.HttpStatus;

public enum SuccessType {
    /**
     * 200 OK
     */
    PROCESS_SUCCESS(HttpStatus.OK, "OK"),
    GET_ONLY_MOVIE_LIST(HttpStatus.OK, "단독 영화가 성공적으로 조회되었습니다"),
    GET_POPULAR_MOVIE_LIST(HttpStatus.OK, "인기 영화가 성공적으로 조회되었습니다"),
    GET_AVAILABLE_SEATS(HttpStatus.OK, "예매 가능 좌석정보가 성공적으로 조회되었습니다");

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
