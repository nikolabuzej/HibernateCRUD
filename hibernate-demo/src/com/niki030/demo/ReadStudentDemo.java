package com.niki030.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.niki030.jdbc.Student;


public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session= factory.getCurrentSession();
		try {
			String query="from Student s where s.lastName like 'Buzej%' and s.email like 'niki%'";
			session=factory.getCurrentSession();
			session.beginTransaction();
			List<Student> theStudents=session.createQuery(query).getResultList();
			for(Student tempStudent:theStudents) {
				System.out.println(tempStudent);
			}
	
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}

}
