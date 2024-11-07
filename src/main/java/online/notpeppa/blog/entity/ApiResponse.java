package online.notpeppa.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiResponse<T> {
    private Integer code;
    private T data;
    private String msg;

    public ApiResponse(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> ApiResponse<T> success( T data, String msg) {
        return new ApiResponse<>(200,data,msg);
    }

    public static <T> ApiResponse<T> fail(Integer code, T data, String msg) {
        return new ApiResponse<>(code, data, msg);
    }
}
