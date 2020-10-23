package com.stephane.springbatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringbatchApplication implements CommandLineRunner {
		
	public static void main(String[] args) {
		SpringApplication.run(SpringbatchApplication.class, args);
	}

	@SuppressWarnings("unused")
	@Override
	public void run(String... args) throws Exception {

	}
}
