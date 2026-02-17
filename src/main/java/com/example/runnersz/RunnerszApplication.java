package com.example.runnersz;

import com.example.runnersz.run.Location;
import com.example.runnersz.run.Run;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RunnerszApplication {


	private static final Logger logger = LoggerFactory.getLogger(RunnerszApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(RunnerszApplication.class, args);

	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(30, ChronoUnit.MINUTES), Location.OUTDOOR);
			logger.info("Created run: {}", run);
		};
	}

}
