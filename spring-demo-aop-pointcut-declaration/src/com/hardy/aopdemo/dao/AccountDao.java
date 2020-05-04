package com.hardy.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.hardy.aopdemo.Account;

@Component
public class AccountDao {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(){
		System.out.println(getClass()+"doing my db work :adding an account");
	}
	
	public String addMatchOnReturnType() {
		System.out.println("matchOnReturn type");
		return null;
	}

	public void addAccount(Account obj){
		System.out.println("adding account");
	}
	
	public void addAccount(Account obj,boolean vip){
		System.out.println("adding account with vip");
	}
	
	public boolean doWork() {
		System.out.println("doing work");
		return false;
	}

	public String getName() {
		System.out.println("getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	
}
