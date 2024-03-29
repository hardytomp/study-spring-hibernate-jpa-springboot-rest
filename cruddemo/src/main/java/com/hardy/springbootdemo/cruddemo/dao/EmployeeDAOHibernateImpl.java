package com.hardy.springbootdemo.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;



import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hardy.springbootdemo.cruddemo.entity.Employee;



@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
	
	//define field fr entity manager
	
	private EntityManager entityManager;
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	@Override
	public List<Employee> findAllEmployee() {
		// get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		
		//create the query
		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		
		//execute query
		List<Employee> employees = theQuery.getResultList();
		//retuen result
		return employees;
	}



	public Employee findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee emp = currentSession.get(Employee.class, id);
		
		return emp;
	}




	public void save(Employee emp) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(emp);
	
	}




	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", id);
		theQuery.executeUpdate();
		
	}

}
