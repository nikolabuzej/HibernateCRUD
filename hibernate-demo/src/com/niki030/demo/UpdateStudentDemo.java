package com.niki030.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.niki030.jdbc.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory= new Configuration().configure().addAnnotatedClass(Student.class)
		.buildSessionFactory();
		Session session= factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Student myStudent=session.get(Student.class, 1);
			myStudent.setFirstName("Skubi");
			session.getTransaction().commit();
			session=factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='foo@gmail.com' where firstName like 'Nikola%' ").executeUpdate();
			session.getTransaction().commit();
		}
		finally{
			session.close();
		}
	}
	
}
