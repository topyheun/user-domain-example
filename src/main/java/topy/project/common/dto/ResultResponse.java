package topy.project.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResultResponse<D> {

    private final int code;
    private final String message;
    private final D data;

    public ResultResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public static <D> ResultResponse<D> result(int code, String message) {
        return new ResultResponse<>(code, message, null);
    }

    public static <D> ResultResponse<D> result(int code, String message, D data) {
        return new ResultResponse<>(code, message, data);
    }
}
