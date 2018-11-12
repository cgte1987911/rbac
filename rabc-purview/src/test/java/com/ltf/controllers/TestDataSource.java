package com.ltf.controllers;

import com.ltf.appApplication;
import com.ltf.model.User;
import com.ltf.mybatis.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Date;

@SpringBootTest(classes = appApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Slf4j
public class TestDataSource {
   @Resource
    private UserService serService ;
    @Test
    public void home() throws Exception {
        System.out.println(this.serService.list().size());
    }
    @Test
    public void testAdd() throws Exception {
        User user=new User();
        user.setBirthday(new Date());
        user.setName("文1文");
        System.out.println(111);
        System.out.println(this.serService.add(user));
    }
}