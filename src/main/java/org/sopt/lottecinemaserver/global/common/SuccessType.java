package org.sopt.lottecinemaserver.global.common;

import org.springframework.http.HttpStatus;

public enum SuccessType {
    /**
     * 200 OK
     */
    PROCESS_SUCCESS(HttpStatus.OK, "OK"),
    GET_ONLY_MOVIE_LIST(HttpStatus.OK, "단독 영화가 성공적으로 조회되었습니다"),
    GET_POPULAR_MOVIE_LIST(HttpStatus.OK, "인기 영화가 성공적으로 조회되었습니다"),
    GET_AVAILABLE_SEATS(HttpStatus.OK, "예매 가능 좌석정보가 성공적으로 조회되었습니다"),
    POST_RESERVE_SEATS(HttpStatus.OK, "예매에 성공했습니다"),
    GET_SCREEN_TIME_LIST_SUCCESS(HttpStatus.OK, "성공적으로 상영관,상영시간 리스트를 조회했습니다."),
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
