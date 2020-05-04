package com.hardy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hardy.hibernate.demo.entity.Course;
import com.hardy.hibernate.demo.entity.Instructor;
import com.hardy.hibernate.demo.entity.InstructorDetail;
import com.hardy.hibernate.demo.entity.Student;

public class LazyLoadingIssues {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start transaction
			System.out.println("transaction begin");
			session.beginTransaction();
			
			
			//get the instructor from db
			int id =1;
			Instructor temp = session.get(Instructor.class, id);
			
			System.out.println("DEBUG----instructor"+temp);
			
			//grt course for instructor
			
			
			session.getTransaction().commit();
			
			//closing the session
			session.close();
			
			//should fail as it is lazy loaded
			System.out.println("courses"+temp.getCourses());
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
