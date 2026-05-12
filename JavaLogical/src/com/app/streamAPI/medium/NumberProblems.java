package com.app.streamAPI.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberProblems {
	//    Second max   =====================
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,2,3,14,15,26,27,38,39,40,14);
		Integer secMax = nums.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).skip(1).findFirst().get();
		System.out.println(secMax);
		
		//   Duplicate element ===========
		List<Entry<Integer, Long>> list = nums.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().filter(e-> e.getValue()>1).toList();
		
		System.out.println(list);
		
		//  Partition number Even & Odd  ============
		Map<String, List<Integer>> collect = nums.stream().collect(Collectors.groupingBy(n->n%2==0?"Even":"Odd"));
		
		collect.entrySet().forEach(e->System.out.println(e.getKey()+" : "+e.getValue()));
		
		List<Integer> nums2 = Arrays.asList(1,2,3,14,125,236,247,358,369,470,184);
		
		List<Integer> merged = Stream.concat(nums.stream(), nums2.stream()).distinct().toList();
		
		System.out.println("Merged num1 & num2 :"+merged);
		
	}
}
