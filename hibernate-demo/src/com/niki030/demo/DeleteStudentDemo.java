package com.niki030.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.niki030.jdbc.Student;

public class DeleteStudentDemo {
	public static void main(String[] args) {
		SessionFactory factory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student forDeletion= session.get(Student.class, 2);
			session.delete(forDeletion);
			session.createQuery("delete from Student where firstName='Procitani'").executeUpdate();
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}
	}
}
