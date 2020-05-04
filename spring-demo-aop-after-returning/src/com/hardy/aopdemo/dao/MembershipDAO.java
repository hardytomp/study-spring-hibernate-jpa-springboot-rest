package com.hardy.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		
		System.out.println(getClass()+":DING STUFF ADDING A MEMBER SHIP ACCOUNT");
		
	}
	

	public boolean goToSleep() {
		System.out.println("goToSleep");
		return false;
	}
}
