package com.ltf.controllers;

import com.alibaba.druid.pool.DruidDataSource;
import com.ltf.utils.JsonData;

import com.ltf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
    @RequestMapping("/hello")

    public String  home(){

        return "test";
    }

    @RequestMapping(value = "/testfd" ,method=RequestMethod.POST)
    @ResponseBody
    public JsonData  test(@Validated User user) {
        System.out.println(user.getName());
        return JsonData.success(user);
    }
}
