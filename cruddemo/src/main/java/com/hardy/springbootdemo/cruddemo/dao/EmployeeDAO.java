package com.hardy.springbootdemo.cruddemo.dao;

import java.util.List;

import com.hardy.springbootdemo.cruddemo.entity.Employee;

public interface EmployeeDAO {

	
	public List<Employee> findAllEmployee();
	
	public Employee findById(int id);
	
	public void save(Employee emp);
	
	public void deleteById(int id);
}
