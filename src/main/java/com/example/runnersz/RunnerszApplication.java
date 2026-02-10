package com.example.runnersz;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerszApplication {


	private static final Logger logger = LoggerFactory.getLogger(RunnerszApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(RunnerszApplication.class, args);

		logger.info("Application started!");
		logger.info("Something changed");
	}

}
