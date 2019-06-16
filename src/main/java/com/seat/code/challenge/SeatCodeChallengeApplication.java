package com.seat.code.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@PropertySources({
//	  @PropertySource(
//	      factory = YamlPropertySourceFactory.class,
//	      value = "file:./config/application.yaml")
//	})
@SpringBootApplication(scanBasePackages = {"com.seat.code.challenge"})
public class SeatCodeChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeatCodeChallengeApplication.class, args);
	}
}
