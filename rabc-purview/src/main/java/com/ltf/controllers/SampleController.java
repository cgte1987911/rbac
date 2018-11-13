package com.ltf.controllers;

import com.ltf.utils.JsonData;

import lombok.extern.slf4j.Slf4j;

import com.ltf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dreamneverdie
 *
 */
@Slf4j
@Controller
public class SampleController {
	/**
	 * @return 返回test页面
	 */
	@RequestMapping("/hello2")

	public String home() {

		return "test";
	}

	/**
	 * @param msg
	 *            url带的参数
	 * @return 输出ajax字符串到页面
	 */
	@RequestMapping(value = "/echo/{message}", method = RequestMethod.GET)
	@ResponseBody
	public String echo(@PathVariable("message") String msg) {

		return "helloworld" + msg;
	}

	/**
	 * @param user	用户对象
	 * @return	ajax返回实体类对象
	 */
	@RequestMapping(value = "/testfd", method = RequestMethod.POST)
	@ResponseBody
	public JsonData test(@Validated User user) {
		log.info(user.getName());
		return JsonData.success(user);
	}
}
