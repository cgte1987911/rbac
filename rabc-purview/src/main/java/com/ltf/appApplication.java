package com.ltf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class appApplication {
    public static void main(String[] args){
        SpringApplication.run(appApplication.class, args);
    }
}
