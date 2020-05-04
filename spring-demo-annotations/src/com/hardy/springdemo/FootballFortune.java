package com.hardy.springdemo;

public class FootballFortune implements FortuneService {

	public FootballFortune() {
		System.out.println("Football fortune constructor");
	}
	
	@Override
	public String getFortune() {

		return "U will win ballonDor one day";
	}

}
