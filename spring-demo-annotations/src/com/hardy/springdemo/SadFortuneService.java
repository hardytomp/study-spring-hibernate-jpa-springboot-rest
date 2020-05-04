package com.hardy.springdemo;

public class SadFortuneService implements FortuneService {

	public  SadFortuneService() {
		System.out.println("constructor of sad fortune Service");
	}
	
	@Override
	public String getFortune() {

		return "Today is not u r not day";
	}

}
