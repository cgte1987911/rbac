package com.ltf.controllers;

import com.ltf.utils.JsonData;

import com.ltf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
    @RequestMapping("/hello2")

    public String  home(){

        return "test";
    }
    @RequestMapping(value = "/echo/{message}",method = RequestMethod.GET)
    @ResponseBody
    public String  echo(@PathVariable("message") String msg){

        return "aaaaf123"+msg;
    }

    @RequestMapping(value = "/testfd" ,method=RequestMethod.POST)
    @ResponseBody
    public JsonData  test(@Validated User user) {
        System.out.println(user.getName());
        return JsonData.success(user);
    }
}
