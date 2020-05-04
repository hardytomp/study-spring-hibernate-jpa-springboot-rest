package com.hardy.springbootdemo.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hardy.springbootdemo.thymeleafdemo.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	//Spring JPA will parse the method name look for 
	//specific patterns and create appropriate query
	public List<Employee> findAllByOrderByLastNameAsc();

}
