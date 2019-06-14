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
	
//		ArrayList<String> commands = new ArrayList<String>();
//		
//		commands.add("5 5");
//		commands.add("1 2 N");
//		commands.add("L M L M L M L M M");
//		commands.add("3 3 E");
//		commands.add("M M R M M R M R R M");
//		
//		System.out.println("===============");
//		NASAOrchestrator or = new NASAOrchestrator(commands);
//		or.executeCommands();
	}
}
