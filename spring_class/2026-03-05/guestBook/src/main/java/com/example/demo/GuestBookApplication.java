package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// BaseEntity 의 리스너 활성화 선언
@EnableJpaAuditing
public class GuestBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestBookApplication.class, args);
	}

}
