package com.hardy.aopdemo;

public class Account {
	
	private String name;
	private String level;
	
	
	public Account() {
		System.out.println("default constructor");
	}
	
	
	public Account(String name, String level) {
		System.out.println("param constructor");
		this.name = name;
		this.level = level;
	}

	
	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	

}
