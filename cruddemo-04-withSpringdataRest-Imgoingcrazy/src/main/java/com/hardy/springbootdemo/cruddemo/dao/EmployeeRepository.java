package com.hardy.springbootdemo.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hardy.springbootdemo.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
