package com.hardy.assignements.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hardy.assignements.hibernate.entity.Employee;

public class ReadTest {
	
	

		public static void main(String[] args) {
		
			// create session factory
			SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
			
			// create session
			Session session = factory.getCurrentSession();
			
			try {

				Employee employee3 = new Employee("hardy", "tom", "amazon");
				
				session.beginTransaction();
				session.save(employee3);
				session.getTransaction().commit();
				
				System.out.println("new entrys id"+employee3.getId());
				
				session = factory.getCurrentSession();
				session.beginTransaction();
				Employee retrieved=session.get(Employee.class, employee3.getId());
				System.out.println(retrieved.toString());
				session.getTransaction().commit();
				
				
				
			} finally  {
				factory.close();
			}
			
		}

	

}
