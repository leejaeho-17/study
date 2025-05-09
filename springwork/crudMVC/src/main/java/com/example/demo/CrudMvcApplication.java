package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"crud.*"})
@MapperScan({"crud.mapper"})
public class CrudMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudMvcApplication.class, args);
	}

}
