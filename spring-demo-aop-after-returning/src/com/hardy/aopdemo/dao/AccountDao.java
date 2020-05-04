package com.hardy.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hardy.aopdemo.Account;

@Component
public class AccountDao {
	
	private String name;
	private String serviceCode;
	
	
	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<Account>();
		
		Account temp1 = new Account("Amalu","Laji");
		Account temp2 = new Account("Hardy","Tom");
		Account temp3 = new Account("Hardy","Amalu");
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
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
