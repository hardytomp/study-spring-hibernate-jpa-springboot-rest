package com.hardy.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {

		return "today is u r lucky day";
	}

}
