package com.msbhosale.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.msbhosale.hibernate.bean.Person;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();

		Person person = new Person(101, "Ajay", "Patil");
		List<String> h1 = new ArrayList<String>();
		h1.add("Reading");
		h1.add("Coding");
		person.setHobbies(h1);
		
		
		Person person2 = new Person(102, "Amit", "Patil");
		List<String> h2 = new ArrayList<String>();
		h2.add("Swimming");
		person2.setHobbies(h2);

		session.save(person);
		session.save(person2);

		session.getTransaction().commit();
		session.close();

		/*-----------------------------------*/

		Session session2 = factory.openSession();
		session2.beginTransaction();

		Query query = session2.createQuery("from Person");

		List<Person> list = query.getResultList();

		for (Person p : list) {

			System.out.println(p);
		}

		session2.getTransaction().commit();
		session.close();

		/*
		 * Session session2 = factory.openSession(); session2.beginTransaction();
		 * 
		 * Person person2 = session2.get(Person.class, 101);
		 * 
		 * System.out.println(person2);
		 * 
		 * session2.getTransaction().commit(); session.close();
		 */
	}
}