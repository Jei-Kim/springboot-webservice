package com.jojoldu.book.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) //스프링부트의 자동설정, 스프링빈 읽기와 생성 모두 자동 처리 - 프로젝트 최상단 위치
public class Application {
    public static void main(String [] args) {
        SpringApplication.run(Application.class, args); // 내장 was 실행
    }
}
