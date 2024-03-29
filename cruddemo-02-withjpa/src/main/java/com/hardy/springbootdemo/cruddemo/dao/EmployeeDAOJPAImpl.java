package com.hardy.springbootdemo.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hardy.springbootdemo.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{
	
	private EntityManager entityManager;
	
	

	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAllEmployee() {
		
		Query theQuery = entityManager.createQuery("from Employee");
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Employee emp= entityManager.find(Employee.class, id);
		return emp;
	}

	@Override
	public void save(Employee emp) {
		Employee dbEmployee = entityManager.merge(emp);
		//update with id from db of new obj created for hibernate this step is not needed not need e
		emp.setId(dbEmployee.getId());
		
	}

	@Override
	public void deleteById(int id) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", id);
		theQuery.executeUpdate();
		
	}

}
