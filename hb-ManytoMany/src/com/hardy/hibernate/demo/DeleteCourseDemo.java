package com.hardy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hardy.hibernate.demo.entity.Course;
import com.hardy.hibernate.demo.entity.Instructor;
import com.hardy.hibernate.demo.entity.InstructorDetail;
import com.hardy.hibernate.demo.entity.Review;
import com.hardy.hibernate.demo.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start transaction
			System.out.println("transaction begin");
			session.beginTransaction();

			int courseId=10;
			Course tempCourse = session.get(Course.class, courseId);
			
			System.out.println("Deleting  course\n"+tempCourse);
			session.delete(tempCourse);
			
			
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
