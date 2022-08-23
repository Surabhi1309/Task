package com.filmcorporation.dao;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.filmcorporation.model.MovieEntity;
import com.filmcorporation.util.HibernateUtil;

public class MovieDaoImpl implements MovieDao {

	public void addMovie(MovieEntity movie) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(movie);
		session.getTransaction().commit();
		session.close();
	}

	public void maxRevenueForLang(String language) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("select language, max(revenueDollers) from MovieEntity group by language having language= :lang");
		query.setParameter("lang", language);
		List<?> list = query.list();
		System.out.println("Max Revenue for the language: "+language);
		for(int i=0; i<list.size(); i++) {
			Object[] row = (Object[]) list.get(i);
			System.out.println(row[0]+", "+ row[1]);
		}
	}

	public void minRevenueForLang(String language) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("select language, min(revenueDollers) from MovieEntity group by language having language= :lang");
		query.setParameter("lang", language);
		List<?> list = query.list();
		System.out.println("Min Revenue for the language: "+language);
		for(int i=0; i<list.size(); i++) {
			Object[] row = (Object[]) list.get(i);
			System.out.println(row[0]+", "+ row[1]);
		}
		
	}

	@Override
	public void noOfMoviesForLanguage(String language) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("select count(*) from MovieEntity group by language having language= :lang");
		query.setParameter("lang", language);
		List<Integer> list = query.list();
		System.out.println("Movies count for language "+language+" is "+list.get(0));		
		
	}

	@Override
	public Long sumOfRevenueForLanguage(String language) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("select sum(revenueDollers) from MovieEntity group by language having language= :lang");
		query.setParameter("lang", language);
		List<Long> list = query.list();
//		System.out.println("Movies count for language "+language+" is "+list.get(0));	
		Long sum = list.get(0);
		return sum;
	}
	

	@Override
	public Double averageOfRevenueForLang(String language) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("select avg(revenueDollers) from MovieEntity group by language having language= :lang");
		query.setParameter("lang", language);
		List<Double> list = query.list();
//		System.out.println("Movies count for language "+language+" is "+list.get(0));	
		Double sum = list.get(0);
		return sum;
	}
	
}
