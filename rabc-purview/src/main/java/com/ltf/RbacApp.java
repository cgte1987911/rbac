package com.ltf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author dreamneverdie
 *
 */
@SpringBootApplication
@EnableTransactionManagement
public class RbacApp {
	
	/**
	 * springboot启动入口
	 * @param args 启动的时候再终端输入参数
	 * 
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(RbacApp.class, args);
	}
}
