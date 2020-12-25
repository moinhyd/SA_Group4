package com.counterC.counterC;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEmailTools
public class CounterCApplication {
	public static void main(String[] args) {
		SpringApplication.run(CounterCApplication.class, args);
	}

}
