package com.hardy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hardy.hibernate.demo.entity.Student;

public class UpdaateStudentDemo {

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

			int studentId =1;
			
			//now get a new session and  start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retreieve student based on id
			System.out.println("\nGetting student with id"+studentId);
			Student retrievedStudent = session.get(Student.class, studentId);
			//changing the value
			retrievedStudent.setFirstName("junior");
			//udating the object in db when u commit
			//commit the transaction
			session.getTransaction().commit();
			
			//
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			session.createQuery("update Student set email='foo@newMail.com'").executeUpdate();
			
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		

	}

}
