package com.app.streamAPI.basic;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberProblems {
	public static void main(String[] args) {
		//======   Even Number  =======================================================================
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,23,34,221);
		List<Integer> even1 = numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
		
		even1.forEach(System.out::print);
		
		int [] nums = {11,12,13,14,15,16,17,18,19,2};
		
		int[] even2 = Arrays.stream(nums).filter(n-> n%2==0).toArray();
		for(int n:even2) {
			System.out.println(n);
		}
		
		int[] even3 = IntStream.of(nums).filter(n->n%2==0).toArray();
		for(int n:even3) {
			System.out.println(n);
		}
		
		Integer[] even4 =
			    numbers.stream()
			           .filter(n -> n % 2 == 0)
			           .toArray(Integer[]::new);
		for(int n:even4) {
			System.out.println(n);
		}
		

		List<Integer> even5 = Arrays.stream(nums)
		                           .filter(n -> n % 2 == 0)
		                           .boxed()
		                           .collect(Collectors.toList());

		System.out.println(even5);
		//====================  Sorting ======================================================================
		int [] nums2 = {2,5,1,9,2,5,3,2,9};
		int[] sortedNums = IntStream.of(nums2).sorted().toArray();
		for(int n:sortedNums) {
			System.err.println(n);
		}
		List<Integer> nums3 = Arrays.asList(2,5,1,9,2,5,3,2,9);
		nums3.stream().sorted().forEach(System.out::println);
		
		//==== Find Max =============
		
		Integer max1 = nums3.stream().sorted((a,b)->Integer.compare(b, a)).findFirst().get();
		System.err.println(max1);
		
		Integer max2 = nums3.stream().sorted(Comparator.comparing(Integer:: intValue).reversed()).findFirst().get();
		System.out.println(max2);
		
		Integer max3 = nums3.stream().max(Comparator.comparing(Integer::intValue)).get();
		System.out.println(max3);
		
		Integer max4 = nums3.stream().max(Integer::compareTo).get();
		System.out.println(max4);
		
		//======== Sum =======================================================
		
		Integer sum1 = nums3.stream().collect(Collectors.summingInt(a->a));
		System.out.println(sum1);
		
		
		//numbers should be primitive array
		int sum = Arrays.stream(nums).sum();
		System.out.println(sum);
		
		//====== Average ================================
		 Double average = Arrays.stream(nums).average().getAsDouble();
		 System.out.println(average);
		 
		 boolean anyMatch = numbers.stream().anyMatch(n-> n%2==0);
		 boolean allMatch = numbers.stream().allMatch(n-> n%2==0);
		 
		 List<String> list = numbers.stream().map(n-> String.valueOf(n)).filter(s->s.startsWith("2")).toList();
		 list.forEach(s-> System.err.println(s));
		 
		 //==== first 3 element==
		 
		 numbers.stream().limit(3).forEach(System.out::println);
		 numbers.stream().skip(3).forEach(System.out::println);
		 
	}
}
