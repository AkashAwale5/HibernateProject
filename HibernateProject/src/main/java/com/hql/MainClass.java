package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.yash.Student;

public class MainClass {

	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		String query ="from Student";
		Query q = session.createQuery(query);
		//----single
//		q.uniqueResult();
		
		//---------multiple
		List<Student> list = q.list();
		
		for (Student student : list) 
		{
			System.out.println(student.getName());
		}
		
		
		session.close();
		factory.close();
	}

}
