package com.hardy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Template;

import com.hardy.hibernate.demo.entity.Instructor;
import com.hardy.hibernate.demo.entity.InstructorDetail;
import com.hardy.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo2 {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
					
			// start transaction
			System.out.println("transaction begin");
			session.beginTransaction();
			
			int id=3;

			//get instructor detail
			InstructorDetail details = session.get(InstructorDetail.class, id);
			
			//deleting so as we have changed the cascading type from all to other model delete operation 
			//will result in esception as it is bidirectional so we need to make the reference of detial obj as null in instructor obj
			details.getInstructor().setInstructorDetail(null);
			session.delete(details);
			
			
			//commit trasaction
			System.out.println("commiting on session");
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
