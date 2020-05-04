package com.hardy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hardy.hibernate.demo.entity.Course;
import com.hardy.hibernate.demo.entity.Instructor;
import com.hardy.hibernate.demo.entity.InstructorDetail;
import com.hardy.hibernate.demo.entity.Review;
import com.hardy.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			Course tempCourse = new Course("spring boot boy");
			session.save(tempCourse);

			Student tempStudent1 = new Student("hardy", "tom", "hardytom@gmail.com");
			Student tempStudent2 = new Student("amalu", "laji", "laji@gmail.com");
			Student tempStudent3 = new Student("hardy", "amalu", "hardyamal@gmail.com");
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			tempCourse.addStudent(tempStudent3);
			
			System.out.println("saving the  students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			System.out.println("Saved students: " + tempCourse.getStudents());
			System.out.println("Saved students: " + tempStudent1.getCourses());

			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
