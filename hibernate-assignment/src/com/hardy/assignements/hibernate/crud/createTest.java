package com.hardy.assignements.hibernate.crud;

import org.dom4j.dom.DOMNodeHelper.EmptyNodeList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hardy.assignements.hibernate.entity.Employee;



public class createTest {

	public static void main(String[] args) {
	
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			Employee employee1 = new Employee("Amalu", "laji", "TorryHarris");
			Employee employee2 = new Employee("hardy", "tom", "PHILIPS");
			Employee employee3 = new Employee("hardy", "tom", "GE");
			
			session.beginTransaction();
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			session.getTransaction().commit();
		} finally  {
			factory.close();
		}
		
	}

}
