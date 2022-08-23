package com.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.Asset;
import com.model.Employee;
import com.util.HibernateUtil;

public class App {

	public static void main(String[] args) {

		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();

		Session session = sessionfactory.openSession();
		Transaction t = session.beginTransaction();
 insert(session);
	//	read(session);
		//delete(session);
	//	update(session);

		session.getTransaction().commit();
	}
	
	private static void update(Session session) {
		Employee employee = session.get(Employee.class, 101);
		employee.setPassword("emp123");
		session.saveOrUpdate(employee);
	}
	
	private static void delete(Session session) {
		Employee employee = session.get(Employee.class, 10);
		session.remove(employee);
	}


	private static void insert(Session session) {
		Asset asset = new Asset(101, 77777, 89098, "PC", 67899, "PCMC");
		Employee employee = new Employee("Ajay", 15, "ab12152", asset);
		session.save(asset);
		session.save(employee);

	}

	private static void read(Session session) {
		Asset a1 = session.get(Asset.class, 101);
		System.out.println(a1);

		Asset a2 = session.load(Asset.class, 1010);
		System.out.println(a2);

	}
}

