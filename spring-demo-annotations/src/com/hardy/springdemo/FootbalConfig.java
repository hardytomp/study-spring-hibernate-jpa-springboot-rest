package com.hardy.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FootbalConfig {
	@Bean
	FortuneService getfootBallFortune() {
		return new FootballFortune();
	}
	
	@Bean
	Coach getFootBallCoach() {
		return new FootballCoach(new FootballFortune());
	}

}
