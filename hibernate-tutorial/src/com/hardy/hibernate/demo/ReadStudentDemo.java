package com.hardy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hardy.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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

			// create student object 
			System.out.println("creating a new student object");
			Student tempStudent = new Student("daffy", "duck", "daffy@gmail.com");			
			// start transaction
			System.out.println("transaction begin");
			session.beginTransaction();
			//save student object
			System.out.println("saving the student");
			session.save(tempStudent);
			//commit trasaction
			System.out.println("commiting on session");
			session.getTransaction().commit();
			
			// find out the students id primary key
			System.out.println("saved student Generated id"+tempStudent.getId());
			
			//now get a new session and  start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retreieve student based on id
			System.out.println("\nGetting student with id"+tempStudent.getId());
			Student retrievedStudent = session.get(Student.class, tempStudent.getId());
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("\n\nRetrieved student"+retrievedStudent.getFirstName());
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		

	}

}
