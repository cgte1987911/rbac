package com.ltf.controllers;

import com.ltf.utils.BeanValidator;
import com.ltf.utils.JsonData;

import lombok.extern.slf4j.Slf4j;

import com.ltf.exception.ParamException;
import com.ltf.model.User;
import com.ltf.test.TestVo;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
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
	@RequestMapping("/login")

	public String home() {

		return "login";
	}

	/**
	 * @return 跳转后台欢迎页面
	 */
	@RequestMapping("/admin")

	public String admin() {

		return "welcome_admin";
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
	 * @param user
	 *            用户对象
	 * @return ajax返回实体类对象
	 */
	@RequestMapping(value = "/testfd", method = RequestMethod.POST)
	@ResponseBody
	public JsonData test(@Validated User user) {
		log.info(user.getName());
		return JsonData.success(user);
	}

	/**
	 * @param vo	验证实体类参数
	 * @return		返回错误提示信息
	 * @throws ParamException	验证的时候出现的不可预知异常
	 */
	@RequestMapping("/validate.json")
	@ResponseBody
	public JsonData validate(TestVo vo) throws ParamException {
		log.info("validate");
		try {
			Map<String, String> map = BeanValidator.validateObject(vo);
			if (MapUtils.isNotEmpty(map)) {
				for (Map.Entry<String, String> entry : map.entrySet()) {
					log.info("{}->{}", entry.getKey(), entry.getValue());
				}
			}
		} catch (Exception e) {

		}

		return JsonData.success("test validate");
	}
}
