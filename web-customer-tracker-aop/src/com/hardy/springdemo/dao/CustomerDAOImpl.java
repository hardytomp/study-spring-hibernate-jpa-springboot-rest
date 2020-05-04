package com.hardy.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hardy.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName",
															Customer.class);
		
		
		//execute query and get result list
		
		List<Customer> customers =query.getResultList();
		
		//return the results
		
		return customers;
	}


	@Override
	public void saveCustomer(Customer customer) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//currentSession.save(customer);
		currentSession.saveOrUpdate(customer);
		
	}


	@Override
	public Customer getCustomer(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Customer customer =currentSession.get(Customer.class, id);
		return customer;
	}


	@Override
	public void deleteCustomer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
/*		Customer customer =currentSession.get(Customer.class, id);
		currentSession.delete(customer);*/
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId",id);
		query.executeUpdate();
	}

}
