package com.filmcorporation.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.filmcorporation.model.DirectorEntity;
import com.filmcorporation.model.HollyWoodEntity;
import com.filmcorporation.model.MovieEntity;
import com.filmcorporation.util.HibernateUtil;

public class MovieDaoImpl implements MovieDao {

	public void getMovieDetails(String lang) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		if(lang.equalsIgnoreCase("english")) {
			Query<HollyWoodEntity> query = session.createQuery("from HollyWoodEntity");
			List<HollyWoodEntity> list = query.list();
			list.forEach(movie->System.out.println(movie));
		}else {
			Query<MovieEntity> query = session.createQuery("from MovieEntity m where m.language= :lang");
			query.setParameter("lang", lang);
			List<MovieEntity> list = query.list();
//			System.out.println(list);
			list.forEach(movie->System.out.println(movie));
		}
		
	}

	public void getMovieByDirector(String directorName) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query<MovieEntity> query1 = session.createQuery("from MovieEntity");
//		query1.setParameter("directorName", directorName);
		List<MovieEntity> list1 = query1.list();
		for(int i=0;i<list1.size();i++) {
			if(list1.get(i).getDirectorEntity().getDirectorName().equalsIgnoreCase(directorName))
				System.out.println(list1.get(i));
		}
		Query<HollyWoodEntity> query2 = session.createQuery("from HollyWoodEntity");
//		query2.setParameter("directorName", directorName);
		List<HollyWoodEntity> list2 = query2.list();
		
		  for(int i=0;i<list2.size();i++) {
		  if(list2.get(i).getDirectorEntity().getDirectorName().equalsIgnoreCase(directorName)) 
			  System.out.println(list2.get(i)); 
		  }
	}

	public void addMovie(MovieEntity movieEntity) {
		// TODO Auto-generated method stub
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		if(movieEntity.getLanguage().equalsIgnoreCase("english")) {
			String movieId = movieEntity.getMovieId();
			String movieName = movieEntity.getMovieName();
			String language = movieEntity.getLanguage();
			Integer releasedIn = movieEntity.getReleasedIn();
			Integer revenueDollers = movieEntity.getRevenueDollers();
 			DirectorEntity directorEntity = movieEntity.getDirectorEntity();
			HollyWoodEntity hollyWoodEntity = new HollyWoodEntity(movieId, movieName, language, releasedIn, revenueDollers, directorEntity);
			session.save(hollyWoodEntity);
		}else {
			session.save(movieEntity);
		}
		session.getTransaction().commit();
		session.close();
		
	}

	public void deleteMovie(String movieName) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from MovieEntity m where m.movieName = :movieName");
		query.setParameter("movieName", movieName);
		int num = query.executeUpdate();
		session.getTransaction().commit();
		System.out.println("no of rows deleted "+num);
		session.close();
	}

	public void getDistinctLanguages() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Query<String> query1 = session.createQuery("select distinct(language) from MovieEntity");
		List<String> distinctLang= query1.list();
		Query<String> query2 = session.createQuery("select distinct(language) from HollyWoodEntity");
		List<String> distinctLang2 = query2.list();
		distinctLang.addAll(distinctLang2);
		System.out.println(distinctLang);
		session.close();
	}

	@Override
	public void updateRevenue(String movieName) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Query<MovieEntity> query1 = session.createQuery("from MovieEntity where movieName = :movieName");
		query1.setParameter("movieName",movieName);
		List<MovieEntity> movies1 = query1.list();
		if(movies1!=null) {
			for(MovieEntity M : movies1) {
				Integer newRevenue = M.getRevenueDollers()+100000;
				M.setRevenueDollers(newRevenue);
				session.update(M);
				System.out.println("updated revenue for the movie :"+M.getMovieName()+" is :"+M.getRevenueDollers());
			}
		}
		Query<HollyWoodEntity> query2 = session.createQuery("from HollyWoodEntity where movieName = :movieName");
		query2.setParameter("movieName",movieName);
		List<HollyWoodEntity> movies2 = query2.list();
		if(movies2!=null) {
			for(HollyWoodEntity M : movies2) {
				Integer newRevenue = M.getRevenueDollers()+100000;
				M.setRevenueDollers(newRevenue);
				session.update(M);
				System.out.println("updated revenue for the movie :"+M.getMovieName()+" released in "+M.getReleasedIn()+" is :"+M.getRevenueDollers());
			}
		}		
	}

}
