package com.hardy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hardy.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use session object save java object

			// create 3 student object 
			System.out.println("creating 3 student object");
			Student tempStudent1 = new Student("Amalu", "laji", "amalu@gmail.com");
			Student tempStudent2 = new Student("hardy", "tom", "tom@gmail.com");
			Student tempStudent3 = new Student("anna", "hardy", "anna@gmail.com");
			// start transaction
			System.out.println("transaction begin");
			session.beginTransaction();
			//save student object
			System.out.println("saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			//commit trasaction
			System.out.println("commiting on session");
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
