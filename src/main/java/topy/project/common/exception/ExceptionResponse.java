package topy.project.common.exception;

import lombok.Getter;

@Getter
public class ExceptionResponse {

    private String message;

    public ExceptionResponse(String message) {
        this.message = message;
    }
}
