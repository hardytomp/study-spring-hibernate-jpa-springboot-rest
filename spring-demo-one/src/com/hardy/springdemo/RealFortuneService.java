package com.hardy.springdemo;

import java.util.Random;

public class RealFortuneService implements FortuneService{

	String fortunes[] = {"Today is a bad day",
							"You will do great things today",
							"lets see what happens today"};
	
	@Override
	public String getFortune() {
		Random rand = new Random();
		int val = rand.nextInt(3);
		return fortunes[val];
	}

}
