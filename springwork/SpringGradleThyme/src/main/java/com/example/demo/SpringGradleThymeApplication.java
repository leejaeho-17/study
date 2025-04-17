package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"test.*"})
public class SpringGradleThymeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGradleThymeApplication.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("=== Spring Boot에서 등록된 Bean 목록 ===");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                if (beanName.contains("dispatcherServlet")) {  // DispatcherServlet 확인
                    System.out.println(beanName);
                }
            }
        };
    }
}
