package com.yash;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();

		//student 1
		Student st= new Student();
		st.setId(123);
		st.setName("akash");
		st.setCity("pune");
		
		Certificate cert = new Certificate();
		cert.setCourse("java");
		cert.setDuration("3 months");
		
		st.setCerti(cert);
		
		//student 2
		Student st1= new Student();
		st1.setId(124);
		st1.setName("akki");
		st1.setCity("latur");
		
		Certificate cert1 = new Certificate();
		cert1.setCourse("python");
		cert1.setDuration("3 months");
		
		st1.setCerti(cert1);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		//save object
		session.save(st);
		session.save(st1);
		
		tx.commit();
		session.close();
		factory.close();

	}

}
