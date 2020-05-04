package com.hardy.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.hardy.springdemo")
@PropertySource("classpath:sport.properties")
public class SportsConfig {
	public SportsConfig() {
		super();
		System.out.println("Configuration class creation-SportsConfig");
	}
	
	//define bean for fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swim coach and inject dependecy
	
	//method name is the beanID
	@Bean
	public Coach swimCoachs() {
		return new SwimCoach(sadFortuneService());
	}
	

}
