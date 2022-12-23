package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();

		// create Question 1
//		Question que = new Question();
//		que.setQueId(12);
//		que.setQue("What is Java?");
//
////		// create answer 1
//		Answer ans = new Answer();
//		ans.setAnswer_id(1001);
//		ans.setAnswer("java is programming language");
//		ans.setQuestion(que);
//
//		
//		Answer ans1 = new Answer();
//		ans1.setAnswer_id(1002);
//		ans1.setAnswer("java is easy");
//		ans1.setQuestion(que);
//
//		ArrayList<Answer> alist = new ArrayList<Answer>();
//		alist.add(ans1);
//		alist.add(ans);
//		que.setAnswers(alist);

		// create Question
		

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

//		session.save(que);
//		session.save(ans);
//		session.save(ans1);
//		
		System.out.println("data saved !!!");
		
//		tx.commit();
		
		//fetch data
		Question question = session.get(Question.class, 12);
		System.out.println(question.getQue());
		
		for (Answer answer : question.getAnswers())
		{
			System.out.println(answer.getAnswer());
		}
		
		
		session.close();
		factory.close();
	}

}
