package com.app.streamAPI.hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test2 {
	
	public static void main(String[] args) {
		
		int a[]= {1,2,4,5};
		
		
		int n= a.length+1;
		
	int expectsum = n*(n+1)/2;
	
	int sum = Arrays.stream(a).sum();
	
	int missing= expectsum-sum;
	System.out.println(missing);
	
	
	
		
		
		

		
		int  min = Arrays.stream(a).min().getAsInt();
		int max = Arrays.stream(a).max().getAsInt();
		
		
		
		List<Integer> collect = Arrays.stream(a).boxed().collect(Collectors.toList());
		
		int[] array = IntStream.rangeClosed(min, max).filter(c->!collect.contains(c)).toArray();
		System.out.println(Arrays.toString(array));
		
		
		
		
		
		
	}

}
