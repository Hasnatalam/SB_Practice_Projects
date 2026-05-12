package com.app.streamAPI.hard;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringProblems {
	public static void main(String[] args) {		
		
		String str = "aaabbbcccddde1";
				
		List<String> str1 = Arrays.asList("ataaza","bbb","cctdd   c");
		
		//Vowel counting
		System.out.println("Vowel Counting");
		List<Character> vowel = List.of('a','e','i','o','u');
		long vowelCount = str.toLowerCase().chars().mapToObj(c->(char)c). filter(c->vowel.contains(c)).count();
		System.out.println(vowelCount);
		
		//No of digit in a digit
		System.out.println("No of digit in String");
		long digitCount = str.chars().filter(c->c>='0'&&c<='9').count();
		System.out.println(digitCount);
		
		//Remove duplicate character
		System.out.println("Distinct character");
		String nonRptChar = str.chars().mapToObj(c->String.valueOf((char)c)).distinct().collect(Collectors.joining());
		System.out.println(nonRptChar);
		
		//Char Freqency
		System.out.println("Character Frequency");
		Map<Character, Long> charFreq = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		charFreq.forEach((k,v)->System.err.println(k+" : "+v));
		
		Map<Character, Long> charFreq2 = str1.stream().flatMap(s->s.chars().mapToObj(c-> (char)c)).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		charFreq2.forEach((k,v)->System.out.println(k+" : "+v));
		
		//Check if String contains only alphabets
		System.out.println("Is only alphabates");
		boolean isOnlyAlphabates = str.toLowerCase().chars().allMatch(c->c>='a'&&c<='z');
		System.out.println(isOnlyAlphabates);
		
		//First None repeating Character
		System.out.println("First None repeating charaater");
		Character nonRepeat = str1.stream().flatMap(s->s.chars().mapToObj(c->(char)c)).collect(Collectors.collectingAndThen(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()),map->map.entrySet().stream().filter(e->e.getValue()==1).map(e->e.getKey()).findFirst().get()));
		System.out.println(nonRepeat);
		
		
		
		//Intstream.range()
		
		List<Integer> list = IntStream.range(1, 11).boxed().toList();
		System.out.println(list);
		
		int sum = IntStream.range(1, 101).sum();
		System.out.println(sum);
		
		Integer factorial = IntStream.range(1, 6).boxed().collect(Collectors.reducing(1,(a,b)->a*b));
		System.out.println(factorial);
	}
}
