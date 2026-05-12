package com.app.streamAPI.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringProblems {
	public static void main(String[] args) {
		List<String> cities = Arrays.asList(
			    "Hyderabad","Mumbai","Delhi","Chennai","Bangalore",
			    "Pune","Kolkata","Ahmedabad","Jaipur","Lucknow",
			    "Visakhapatnam","Vijayawada","Nagpur","Indore","Bhopal",
			    "Surat","Patna","Coimbatore","Mysore","Noida"
			);
		
		// Group by length =====================
		Map<Integer, List<String>> collect = cities.stream().collect(Collectors.groupingBy(city-> city.length()));
		
		collect.forEach((k,v)->System.out.println(k+" : "+v));
		
		// Sort by length =====================
		List<String> sortedByLength1 = cities.stream().sorted((a,b)-> a.length()-b.length()).toList();
		String longestString= cities.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst().get();
		
		sortedByLength1.forEach(e->System.out.println(e));
		
		System.out.println(longestString);
		
		List<List<String>> cityList = Arrays.asList(Arrays.asList("Hyderabad","Mumbai","Delhi","Chennai","Bangalore"),Arrays.asList("Hyderabad","Mumbai","Delhi","Chennai","Bangalore"));
		
		cityList.stream().flatMap(city -> city.stream()).forEach(System.out::print);
	}
}
