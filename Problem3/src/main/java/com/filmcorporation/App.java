package com.filmcorporation;

import com.filmcorporation.dao.MovieDao;
import com.filmcorporation.dao.MovieDaoImpl;
import com.filmcorporation.model.DirectorEntity;
import com.filmcorporation.model.MovieEntity;
import com.filmcorporation.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
    	MovieDao movieDao = new MovieDaoImpl();
    	//Record 1
    	DirectorEntity directorEntity1 = new DirectorEntity("D101", "Chris Columbus", 1958);
    	MovieEntity movieEntity1 = new MovieEntity("M1001", "Home Alone","English",1990, 476700000, directorEntity1);    	
    	movieDao.addMovie(movieEntity1);
    	//record 2 (with the same director)
    	MovieEntity movieEntity2 = new MovieEntity("M1002", "Home Alone", "English", 1992, 358900000, directorEntity1);
    	movieDao.addMovie(movieEntity2);
    	//record 3
    	DirectorEntity directorEntity2 = new DirectorEntity("D102", "Patrick Read Johnson", 1962);
    	MovieEntity movieEntity3 = new MovieEntity("M1003", "Baby's Day Out", "English", 1994, 16800000, directorEntity2);
    	movieDao.addMovie(movieEntity3);
    	//record 4
    	DirectorEntity directorEntity3 = new DirectorEntity("D103", "Aamir", 1965);
    	MovieEntity movieEntity4 = new MovieEntity("M1004", "Taare Zameen Par", "Hindi", 2007, 13000000, directorEntity3);
    	movieDao.addMovie(movieEntity4);
    	//record 5
    	DirectorEntity directorEntity4 = new DirectorEntity("D104", "R. Balki", null);
    	MovieEntity movieEntity5 = new MovieEntity("M1005", "Paa", "Hindi", 2009, 4700000, directorEntity4);
    	movieDao.addMovie(movieEntity5);
    	
    	System.out.println("**********Movies Details by language**********");
    	movieDao.getMovieDetails("Hindi"); 
    	System.out.println("**********Movies Details by Director**********");
    	movieDao.getMovieByDirector("Aamir");
    	System.out.println("**********Delete Movie by Name**********");
    	movieDao.deleteMovie("Taare Zameen Par");
    	System.out.println("**********Disctinct Languages**********");
    	movieDao.getDistinctLanguages();
    	System.out.println("*******Update the movie rvenue by adding 100000 to it *******");
    	movieDao.updateRevenue("Home Alone");
    	HibernateUtil.closeSessionfactory();
    }
}
