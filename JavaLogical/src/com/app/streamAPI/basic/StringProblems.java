package com.app.streamAPI.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringProblems {
	public static void main(String[] args) {
		List<String> str = new ArrayList<>();
		String strings [] = {"aaa","bbbb","ccccc","abcd","aaa"}; 
		str.addAll(Arrays.stream(strings).toList());
		
		List<String> collect = str.stream().map(s-> s.toUpperCase()).collect(Collectors.toList());
		collect.forEach(s-> System.out.println(s));
		
		//String start with given letter
		
		long count = str.stream().filter(s->s.startsWith("a")).count();
		System.out.println(count);
		long count2 = str.stream().filter(s->s.charAt(0)=='a').count();
		System.out.println(count2);
		
		List<String> list = str.stream().distinct().toList();
		System.out.println(list);
		
		String string = Arrays.stream(strings).collect(Collectors.joining(","));
		
	}
}
