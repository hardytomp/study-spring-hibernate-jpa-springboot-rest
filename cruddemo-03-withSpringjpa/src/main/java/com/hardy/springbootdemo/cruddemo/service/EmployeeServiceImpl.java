package com.hardy.springbootdemo.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.hardy.springbootdemo.cruddemo.dao.EmployeeRepository;
import com.hardy.springbootdemo.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeerepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeerepo) {
		this.employeerepo = employeerepo;
	}

	
	public List<Employee> findAllEmployee() {
		return employeerepo.findAll();
	}

	
	public Employee findById(int id) {
		Optional<Employee> result = employeerepo.findById(id);
		Employee emp =null;
		if(result.isPresent()) {
			emp = result.get();
		} else {
			throw new RuntimeException("Did not find emp "+id);
		}
		return emp;
	}

	
	public void save(Employee emp) {
		employeerepo.save(emp);
		
	}

		public void deleteById(int id) {
		employeerepo.deleteById(id);
		
	}

}
