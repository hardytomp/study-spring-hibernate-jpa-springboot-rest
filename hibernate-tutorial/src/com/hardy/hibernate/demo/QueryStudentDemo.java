package com.hardy.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hardy.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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

			System.out.println("transaction begin");
			session.beginTransaction();
			
			//query student
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display students
			displayStudents(theStudents);

			// query students whose last name is anna
			
			theStudents = session.createQuery("from Student s where s.lastName='anna'").getResultList();
			System.out.println("\n\n");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where "+
												"s.lastName='amalu' OR s.lastName='hardy'").getResultList();
			System.out.println("\n\n");
			displayStudents(theStudents);
			
			//query email like gmail.com
			theStudents = session.createQuery("from Student s where "+
					"s.email LIKE '%gmail.com'").getResultList();
			System.out.println("\n\n");
			displayStudents(theStudents);

			
			
			
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student temp:theStudents) {
			System.out.println(temp);
		}
	}

}
