package com.dddeurope.recycle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.ObjectName;

@SpringBootApplication
public class RecycleJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecycleJavaApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper() {
		var mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(new JavaTimeModule());

		return mapper;
	}

}
