package com.hardy.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create an array of strings
	
	private String data[] = {"try hard bouy u r day will come","may be today is u r day","u will shine like a star"};
	
	private Random rand = new Random();
	
	@Override
	public String getFortune() {
		
		return data[rand.nextInt(data.length)];
	}

}
