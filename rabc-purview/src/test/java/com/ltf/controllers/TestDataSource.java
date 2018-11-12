package com.ltf.controllers;

import com.ltf.RbacApp;
import com.ltf.model.User;
import com.ltf.mybatis.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author dreamneverdie
 *
 */
@SpringBootTest(classes = RbacApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Slf4j
public class TestDataSource {
	@Resource
	private UserService serService;

	/**
	 * @throws Exception
	 * 向上抛出异常
	 */
	@Test
	public void home() throws Exception {
		log.info(String.valueOf(this.serService.list().size()));
	}

	/**
	 * @throws Exception
	 * 向上抛出异常
	 */
	@Test
	public void testAdd() throws Exception {
		User user = new User();
		user.setBirthday(new Date());
		user.setName("文1文");
		log.info(this.serService.add(user).toString());
	}
}
