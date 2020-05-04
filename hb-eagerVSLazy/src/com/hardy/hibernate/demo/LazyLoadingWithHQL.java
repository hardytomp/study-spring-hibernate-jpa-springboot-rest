package com.hardy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hardy.hibernate.demo.entity.Course;
import com.hardy.hibernate.demo.entity.Instructor;
import com.hardy.hibernate.demo.entity.InstructorDetail;
import com.hardy.hibernate.demo.entity.Student;

public class LazyLoadingWithHQL {

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
			
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+"JOIN FETCH i.courses "
					+"where i.id=:theInstructorId"
					,Instructor.class);
			//setParameter on query
			query.setParameter("theInstructorId", id);
			
			//execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Instructor "+tempInstructor);
			
			session.getTransaction().commit();
			
			//closing the session
			session.close();
			System.out.println("closed session");
			
			System.out.println("courses"+tempInstructor.getCourses());

			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
