package com.ltf.commons;

import com.ltf.utils.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(NoHandlerFoundException.class)
    public Map<String, Object> handleException(NoHandlerFoundException e) {
        System.out.println(111);
        String msg ="404页面不存在";


        JsonData jsonData = JsonData.fail(msg);
        return jsonData.toMap();
    }




    @ResponseBody
    @ExceptionHandler(BindException.class)
    public Map<String, Object> handleException(BindException e) {

            BindingResult bindingResult = e.getBindingResult();
            String errorMessage = "校验失败:";
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
               log.error(fieldError.getDefaultMessage()+"\n");
            }
            JsonData jsonData = JsonData.fail(errorMessage);
            return jsonData.toMap();
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException(Exception e) {
        System.out.println(e.getClass());
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        log.error("未知错误:----",e);
        JsonData jsonData = JsonData.fail(msg);
        return jsonData.toMap();
    }
}
