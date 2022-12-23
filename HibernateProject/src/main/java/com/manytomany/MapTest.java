package com.manytomany;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapTest {

	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
	//creating object of employee
		Employee emp = new Employee();
		emp.setEid(12);
		emp.setName("Akash");
		
		Employee emp1 = new Employee();
		emp1.setEid(13);
		emp1.setName("vinod");
			
	// creating object f project
		Project p= new Project();
		p.setPid(22);
		p.setProjectName("Johndeere");
		
		Project p1= new Project();
		p1.setPid(3);
		p1.setProjectName("Caterpilar");
		
	//-------------------------------
		ArrayList<Project> plist = new ArrayList<Project>();
		ArrayList<Employee> elist = new ArrayList<Employee>();
		
		plist.add(p);//add project
		plist.add(p1);
		
		elist.add(emp);//add emp
		elist.add(emp1);
		
		emp.setProjects(plist);//employee1
		p.setEmployees(elist);
		
	//save ---------------------------
		session.save(emp);
		session.save(emp1);
		
		session.save(p);
		session.save(p1);
		
		
		tx.commit();
		session.close();
		factory.close();
	}

}
