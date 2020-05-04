package com.hardy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hardy.hibernate.demo.entity.Instructor;
import com.hardy.hibernate.demo.entity.InstructorDetail;
import com.hardy.hibernate.demo.entity.Student;

public class DeleteDemo {

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
			
			int id=1;
			Instructor temp = session.get(Instructor.class, id);
			
			System.out.println(temp.toString());
			
			if(temp != null) {
				//also delete details obj also because of cascadde_all
				session.delete(temp);
			}
					
			
			
			//commit trasaction
			System.out.println("commiting on session");
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		

	}

}
