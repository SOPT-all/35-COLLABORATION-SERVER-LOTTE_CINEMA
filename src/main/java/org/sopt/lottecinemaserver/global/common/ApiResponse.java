package org.sopt.lottecinemaserver.global.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.sopt.lottecinemaserver.global.exception.ErrorType;

public class ApiResponse<T> {
    private final int code;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }


    public static ApiResponse<?> success(SuccessType successType) {
        return new ApiResponse<>(successType.getHttpStatusCode(), successType.getMessage());
    }

    public static <T> ApiResponse<T> success(SuccessType successType, T data) {
        return new ApiResponse<T>(successType.getHttpStatusCode(), successType.getMessage(), data);
    }

    public static ApiResponse<?> error(ErrorType errorType) {
        return new ApiResponse<>(errorType.getHttpStatusCode(), errorType.getMessage());
    }

    public static <T> ApiResponse<T> error(ErrorType errorType, T data) {
        return new ApiResponse<>(errorType.getHttpStatusCode(), errorType.getMessage(), data);
    }

    public static <T> ApiResponse<Exception> error(ErrorType errorType, Exception e) {
        return new ApiResponse<>(errorType.getHttpStatusCode(), errorType.getMessage(), e);
    }

    public static <T> ApiResponse<Exception> error(ErrorType errorType, String message, Exception e) {
        return new ApiResponse<>(errorType.getHttpStatusCode(), message, e);
    }
}
