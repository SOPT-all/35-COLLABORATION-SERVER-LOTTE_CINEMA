package org.sopt.lottecinemaserver.global.exception;

public class CustomException extends RuntimeException {

    private final ErrorType errorType;

    public CustomException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public int getHttpStatus() {
        return errorType.getHttpStatusCode();
    }
}
