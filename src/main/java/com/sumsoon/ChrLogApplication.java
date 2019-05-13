package com.sumsoon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChrLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChrLogApplication.class, args);

		log.debug("日志测试 log debug");

		log.info("=========================");

		log.error("日志测试 log error");
	}

}
