package org.sopt.lottecinemaserver.global.exception;

import org.springframework.http.HttpStatus;

public enum ErrorType {

    /**
     * 400 BAD REQUEST
     */

    // 표준 오류
    REQUEST_VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    INVALID_TYPE_ERROR(HttpStatus.BAD_REQUEST, "잘못된 타입이 입력되었습니다."),
    INVALID_MISSING_HEADER_ERROR(HttpStatus.BAD_REQUEST, "요청에 필요한 헤더값이 존재하지 않습니다."),
    INVALID_HTTP_REQUEST_ERROR(HttpStatus.BAD_REQUEST, "요청 형식이 허용된 형식과 다릅니다."),
    INVALID_HTTP_METHOD_ERROR(HttpStatus.BAD_REQUEST, "지원되지 않는 HTTP method 요청입니다."),
    INVALID_DUPLE_SEAT_ERROR(HttpStatus.BAD_REQUEST, "동일한 좌석 번호는 중복 예매할 수 없습니다."),

    /**
     * 404 NOT FOUND
     */
    NOT_FOUND_REGION_ERROR(HttpStatus.NOT_FOUND, "존재하지 않는 지역입니다."),
    NOT_FOUND_MOVIE(HttpStatus.NOT_FOUND, "존재하지 않는 영화입니다."),

    /**
     * 409 Conflict
     */
    DUPLE_SEAT(HttpStatus.CONFLICT, "이미 예약된 좌석이 포함되어있습니다."),

    /**
     * 500 INTERNAL SERVER ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 에러가 발생했습니다.");

    private ErrorType(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
