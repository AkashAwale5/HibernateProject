package com.yash;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		
		Student student = session.get(Student.class, 101);
		System.out.println(student);
		
		Address ad = session.get(Address.class, 1);
		System.out.println(ad);
		session.close();
		factory.close();

	}

}
