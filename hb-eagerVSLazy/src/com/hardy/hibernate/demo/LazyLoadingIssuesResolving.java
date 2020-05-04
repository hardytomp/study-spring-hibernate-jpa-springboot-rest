package com.hardy.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hardy.hibernate.demo.entity.Course;
import com.hardy.hibernate.demo.entity.Instructor;
import com.hardy.hibernate.demo.entity.InstructorDetail;
import com.hardy.hibernate.demo.entity.Student;

public class LazyLoadingIssuesResolving {

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
			//System.out.println(temp.getCourses());
			List<Course> courses= temp.getCourses();
			if(courses == null) {
				System.out.println("courses are null");
			}
			System.out.println(courses.isEmpty());
			
			session.getTransaction().commit();
			
			//closing the session
			session.close();
			
			//now this will not fail as it is fetched before session closed
			System.out.println("courses"+temp.getCourses());
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
