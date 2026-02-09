package com.example.runnersz;

import foo.bar.Welcome;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerszApplication {

	public static void main(String[] args) {

		SpringApplication.run(RunnerszApplication.class, args);

		var welcomeMessage = new Welcome();

		System.out.println(welcomeMessage.getWelcomeMessage());
	}

}
