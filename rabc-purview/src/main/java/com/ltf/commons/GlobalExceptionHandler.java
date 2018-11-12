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

/**
 * @author dreamneverdie
 *
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * @param e	404异常
	 * @return 返回json格式404不存在信息
	 */
	@ResponseBody
	@ExceptionHandler(NoHandlerFoundException.class)
	public Map<String, Object> handleException(NoHandlerFoundException e) {
		log.info("111111");
		String msg = "404页面不存在";

		JsonData jsonData = JsonData.fail(msg);
		return jsonData.toMap();
	}

	/**
	 * @param e 校验bean类数据出错时候的信息
	 * @return 返回json数据
	 */
	@ResponseBody
	@ExceptionHandler(BindException.class)
	public Map<String, Object> handleException(BindException e) {

		BindingResult bindingResult = e.getBindingResult();
		String errorMessage = "校验失败:";
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			log.error(fieldError.getDefaultMessage() + "\n");
		}
		JsonData jsonData = JsonData.fail(errorMessage);
		return jsonData.toMap();
	}

	/**
	 * @param e 没有其他异常时走这个默认异常
	 * @return 返回服务器出错信息
	 */
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public Map<String, Object> handleException(Exception e) {
		log.info(e.getClass().toString());
		String msg = e.getMessage();
		if (msg == null || msg.equals("")) {
			msg = "服务器出错";
		}
		log.error("未知错误:----", e);
		JsonData jsonData = JsonData.fail(msg);
		return jsonData.toMap();
	}
}
