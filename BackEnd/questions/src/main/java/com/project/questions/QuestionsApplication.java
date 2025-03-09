package com.project.questions;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
 
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan("com.project")
public class QuestionsApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(QuestionsApplication.class, args);
	}
 
}
