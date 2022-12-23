package com.yash;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws  IOException {
		System.out.println("Project Started!");

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();

		// creating student
		Student st = new Student();
		st.setId(101);
		st.setName("john");
		st.setCity("delhi");

		System.out.println(st);

		
		
		//creating address object
		Address ad = new Address();
		
		ad.setStreet("street 1");
		ad.setCity("delhi");
		ad.setOpen(true);
		ad.setAddeddate(new Date());
		ad.setX(1);
		
		//reading image
		FileInputStream fs = new FileInputStream("src/main/java/yashlogo.png");
		byte[] data= new byte[fs.available()];
		fs.read(data);
		ad.setImage(data);
		
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(st);
		session.save(ad);
		transaction.commit();
		session.close();
		System.out.println("Done,,,,!!!!");
	}
}
