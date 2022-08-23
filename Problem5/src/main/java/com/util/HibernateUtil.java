package com.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.model.Asset;
import com.model.Employee;


public class HibernateUtil {
	private static SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
		            try {
	                Configuration configuration = new Configuration();
	                Properties settings = new Properties();
	                settings.put(Environment.DRIVER,"org.postgresql.Driver");
	                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/hibernate");
	                 settings.put(Environment.USER, "postgres");
	                settings.put(Environment.PASS, "root");
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
	                settings.put(Environment.SHOW_SQL, "true");
	                settings.put(Environment.FORMAT_SQL,"true");
	                settings.put(Environment.HBM2DDL_AUTO, "update");
		                configuration.setProperties(settings);
		                
		                configuration.addAnnotatedClass(Asset.class);
		                configuration.addAnnotatedClass(Employee.class);
		                
		                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                   .applySettings(configuration.getProperties()).build();
	              sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	
	            } catch (Exception e) {
	
	            }
	
	        }
	
	        return sessionFactory;

	    }

	
	
}
