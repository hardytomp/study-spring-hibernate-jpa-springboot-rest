package com.hardy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hardy.hibernate.demo.entity.Course;
import com.hardy.hibernate.demo.entity.Instructor;
import com.hardy.hibernate.demo.entity.InstructorDetail;
import com.hardy.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

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
			
			//create some courses
			Course tempCourse1 = new Course("AI traing");
			Course tempCourse2 = new Course("ML traing");
			Course tempCourse3 = new Course("Angular traing");
			

			//add courses to instructor
			temp.add(tempCourse1);
			temp.add(tempCourse2);
			temp.add(tempCourse3);
			
			//save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);

			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
