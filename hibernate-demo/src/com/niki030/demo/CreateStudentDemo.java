package com.niki030.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.niki030.jdbc.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		Student tempStudent = new Student("Nikola", "Buzej", "niki@gmail.com");
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session= factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(tempStudent);
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}

}
