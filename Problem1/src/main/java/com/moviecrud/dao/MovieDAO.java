package com.moviecrud.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.moviecrud.model.Movie;

public class MovieDAO {

	static SessionFactory sessionFactory;
	static Session session;
	static {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
	}
	
	public String addMovie(Movie movie) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(movie);
		session.getTransaction().commit();
		session.close();
		System.out.println("Movie saved to the DB successfully");
		return "Successfully added";
	}
	
	public void updateMovie(String movieId) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Movie movie = (Movie) session.get(Movie.class, movieId);
		Integer updatedRevenue = movie.getRevenueDollers()+100000;
		movie.setRevenueDollers(updatedRevenue);
		session.update(movie);
		session.getTransaction().commit();
		session.close();
		System.out.println("Movie updated to the DB successfully and updated revenue is "+updatedRevenue);		
	}
	public void deleteMovie(String movieId) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Movie movie = (Movie) session.get(Movie.class, movieId);
		if(movie==null)
			System.out.println("No movie found");
		else {
			session.delete(movie);
			System.out.println("Movie deleted from the DB successfully");	
		}		
		session.getTransaction().commit();
		session.close();	
	}
	public Movie getMovieDetails(String movieId) {
		session = sessionFactory.openSession();
		Movie movie = (Movie) session.get(Movie.class, movieId);
		session.close();
		return movie;
	}
	
	public static void closeSessionFactory() {
		sessionFactory.close();
		//System.out.println("Session Factory closed successfully");
	}

}
