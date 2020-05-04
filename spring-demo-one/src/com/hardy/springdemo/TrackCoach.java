package com.hardy.springdemo;

public class TrackCoach implements Coach {

	public TrackCoach(FortuneService fortuneService) {
		FortuneService = fortuneService;
	}

	private FortuneService FortuneService;
	
	@Override
	public String getDailyWorkout() {
		
		return "track coach run 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it"+FortuneService.getFortune();
	}
	
	// add init method
	public void doMyStartupStuff(){
		System.out.println("Track Coach: my startup stuff");
	}

	
	// add clean up method
	public void doMyCleanupStuff(){
		System.out.println("Track Coach: my clean up stuff");
	}	
}
