package online.notpeppa.blog.handler;

import cn.dev33.satoken.exception.NotLoginException;
import online.notpeppa.blog.constant.ApiResponseCode;
import online.notpeppa.blog.entity.ApiResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@ControllerAdvice
public class NotLoginExceptionHandler {

    // 全局异常拦截（拦截项目中的NotLoginException异常）
    @ExceptionHandler(NotLoginException.class)
    @ResponseBody
    public ApiResponse<Object> handlerNotLoginException(NotLoginException nle)
            throws Exception {

        // 打印堆栈，以供调试
//        nle.printStackTrace();

        // 判断场景值，定制化异常信息
        String message = "";
        if(nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未能读取到有效 token";
        }
        else if(nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token 无效";
        }
        else if(nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token 已过期";
        }
        else if(nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token 已被顶下线";
        }
        else if(nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token 已被踢下线";
        }
        else if(nle.getType().equals(NotLoginException.TOKEN_FREEZE)) {
            message = "token 已被冻结";
        }
        else if(nle.getType().equals(NotLoginException.NO_PREFIX)) {
            message = "未按照指定前缀提交 token";
        }
        else {
            message = "当前会话未登录";
        }

        // 返回给前端
        return ApiResponse.fail(ApiResponseCode.UNAUTHORIZED, null, message);
    }
}
