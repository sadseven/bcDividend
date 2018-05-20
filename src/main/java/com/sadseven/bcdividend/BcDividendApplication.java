package com.sadseven.bcdividend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sadseven.bcdividend.mapper")
public class BcDividendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcDividendApplication.class, args);
	}
}
