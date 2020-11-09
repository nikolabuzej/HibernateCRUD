package com.niki030.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.niki030.jdbc.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session= factory.getCurrentSession();
		try {
			Student tempStudent2 = new Student("Nikola2", "Buzej2", "niki2@gmail.com");
			Student tempStudent3 = new Student("Nikola3", "Buzej3", "niki3@gmail.com");
			Student tempStudent4 = new Student("Nikola4", "Buzej4", "niki4@gmail.com");
			session.beginTransaction();
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.save(tempStudent4);
			
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}
}
