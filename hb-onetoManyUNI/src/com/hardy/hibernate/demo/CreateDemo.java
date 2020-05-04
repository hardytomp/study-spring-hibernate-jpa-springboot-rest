package com.hardy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hardy.hibernate.demo.entity.Instructor;
import com.hardy.hibernate.demo.entity.InstructorDetail;
import com.hardy.hibernate.demo.entity.Student;

public class CreateDemo {

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
			// use session object save java object
/*			Instructor tempInsstructor = new Instructor("Hardy","Tom","hardy@gmail.com");
			InstructorDetail insDetail = new InstructorDetail("http://youtube.com/deFog", "football");
*/
			
			Instructor tempInsstructor = new Instructor("Amalu","Laji","amalu@gmail.com");
			InstructorDetail insDetail = new InstructorDetail("http://youtube.com/fashion", "sing");

			tempInsstructor.setInstructorDetail(insDetail);
			
		
			// start transaction
			System.out.println("transaction begin");
			session.beginTransaction();
			
			
			//save student object
			System.out.println("saving the student");
			session.save(tempInsstructor);
			
			
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
