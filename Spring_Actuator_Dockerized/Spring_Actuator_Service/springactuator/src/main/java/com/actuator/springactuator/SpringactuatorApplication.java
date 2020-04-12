package com.actuator.springactuator;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringactuatorApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringactuatorApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("############################################");
		System.out.println("#  The Actuator in this Service is Enabled #");
		System.out.println("#  This is printed using ApplicationRunner #");
		System.out.println("############################################");
	}

}
