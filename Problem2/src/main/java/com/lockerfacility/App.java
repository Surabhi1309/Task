package com.lockerfacility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lockerfacility.dao.Customer;
import com.lockerfacility.dao.Locker;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = sf.openSession();
    	Locker locker = new Locker(104,"large", 1000);
    	Customer cust = new Customer(1004, "Mahesh", "11-07-1997", "Mumbai", "9876543210", locker);
    	
    	session.beginTransaction();
    	session.save(locker);
    	session.save(cust);
    	session.getTransaction().commit();
    	Customer customer = (Customer)session.get(Customer.class, 1004);
    	System.out.println(customer);
    	session.close();
    	sf.close();
    }
}
