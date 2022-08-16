package com.moviecrud;

import java.util.Scanner;

import com.moviecrud.dao.MovieDAO;
import com.moviecrud.model.Movie;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		
//		  SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); Session
//		  session = sessionFactory.openSession(); 
//		  Movie movie1 = new Movie("1","Khatron Ke Khiladi", "Hindi", 2010, 1000000);		  
//		  session.beginTransaction();
//		  session.save(movie1);
//		  session.getTransaction().commit();
//		  session.close();
//		  sessionFactory.close();
		Scanner sc = new Scanner(System.in);		
		MovieDAO movieDao = new MovieDAO();
		int input = 5;
		do {
			System.out.println("\nChoose an option");
			System.out.println("1. Add Movie\n2. Update Movie\n3. Delete Movie\n4. Get Movie Details\n0. Exit");
			input = sc.nextInt();
			switch (input) {
			case 0: // case 0 is for exit only
				break;
			case 1: System.out.println("Enter the movie details as \nMovieId,  Name,  Language, Released In, Revenue Dollers");
					String movieId=sc.next();
					String name=sc.next();
					String language = sc.next();
					int releasedIn = sc.nextInt();
					int revenueDollers = sc.nextInt();
					Movie movie = new Movie(movieId, name, language, releasedIn, revenueDollers);
					movieDao.addMovie(movie);				
				break;
			case 2: System.out.println("Enter the movie Id: ");
					String id = sc.next();
					movieDao.updateMovie(id);
				break;
			case 3: System.out.println("Enter the Movie Id: ");
					String mid = sc.next();
					movieDao.deleteMovie(mid);
				break;
			case 4: System.out.println("Enter the Movie Id: ");
					String mId = sc.next();
					Movie movieDetail = movieDao.getMovieDetails(mId);
					if(movieDetail==null)
						System.out.println("No records found for the id: "+mId);
					else
					System.out.println(movieDetail);
				break;
			default:
				System.out.println("Enter a valid number between 0 to 4");
				break;
			}
			
		} while (input!=0);
		
		// To add movie 
//		Movie movie1 = new Movie("7", "The Departed", "Hindi", 2019, 1200000);
//		String result = movieDao.addMovie(movie1);
		
		//To update a movie
//		movieDao.updateMovie("5");
		
		//To delete a movie
//		movieDao.deleteMovie("4");
		
		//to get a movie details
//		Movie movie = movieDao.getMovieDetails("2");
//		System.out.println("Movie for the Id "+2+" is\n"+movie);
		
		//To close the Session factory in the end 
		MovieDAO.closeSessionFactory();
		sc.close();
		System.out.println("Thank you!!!");
	}
}
