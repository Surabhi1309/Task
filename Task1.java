package com.task1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task1 {

	public static void main(String[] args) {
		List<Candidate> list = InterviewRepository.getCandidateList();
		Predicate<Candidate> p2 = c -> c.getCity().equalsIgnoreCase("Pune");
		Predicate<Candidate> p3 = c -> c.getCity().equalsIgnoreCase("Banglore");
		Predicate<Candidate> p4 = c -> c.getCity().equalsIgnoreCase("Mumbai");
		Predicate<Candidate> p5 = c -> c.getCity().equalsIgnoreCase("Chennai");
		Predicate<Candidate> e1 = e -> e.getTechnicalExpertise().equalsIgnoreCase("Java");
		Predicate<Candidate> e2 = e -> e.getTechnicalExpertise().equalsIgnoreCase("c#");
		Predicate<Candidate> e3 = e -> e.getTechnicalExpertise().equalsIgnoreCase("C++");

		// list candidate names from Pune city
		List<String> list2 = list.stream().filter(p -> p.getCity().equalsIgnoreCase("pune")).map(e -> e.getName())
				.collect(Collectors.toList());
		System.out.println("List of Pune Candidates: " + list2);

		// list city and count of candidates per city

		long puneCount = list.stream().filter(p2).count();
		long bCount = list.stream().filter(p3).count();
		long mCount = list.stream().filter(p4).count();
		long cCount = list.stream().filter(p5).count();
		System.out.println("Candidate count for  Pune city:" + puneCount);
		System.out.println("Candidate count for  Mumbai city:" + mCount);
		System.out.println("Candidate count for  Banglore city:" + bCount);
		System.out.println("Candidate count for  Chennai city:" + cCount);

		// list technical expertise and count of candidates

		long jCount = list.stream().filter(e1).count();
		long c1Count = list.stream().filter(e2).count();
		long c2Count = list.stream().filter(e3).count();
		System.out.println("Candidate count by Technical Expertise");
		System.out.println("Java:" + jCount);
		System.out.println("C#:" + c1Count);
		System.out.println("C++:" + c2Count);
		System.out.println();

		// list fresher candidates
		System.out.println("Fresher Candidate list:");
		list.stream().filter(f -> f.getYearsOfExperience() == 0).forEach(m -> System.out.println(m.getName()));
		System.out.println();

		// listing candidates with highest experience
		System.out.println("Sorted List of Candidates by Experience");
		list.stream().sorted(Comparator.comparing(Candidate::getYearsOfExperience)).forEach(e -> System.out.println(e));
		System.out.println();

		// sort the candidates by city name
		System.out.println("Sorted List of Candidates by City Name");
		printLine();

	}

	private static void printLine() {
		List<Candidate> list = InterviewRepository.getCandidateList();
		list.stream().sorted(Comparator.comparing(Candidate::getCity))
				.forEach(e -> System.out.println("Candidate Name : " + e.getName() + " ,city : " + e.getCity()));

	}

}
