package com.example.consumerest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//import com.example.consumerest.model.Employee;

@SpringBootApplication
public class ConsumingRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}
//	
//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return args -> {
//			ResponseEntity<Employee[]> response = 
//					restTemplate.getForEntity("http://localhost:8080/list", Employee[].class);
//		}
//	}
}
