package com.thiruacademy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewQuestions {

	public static void main(String[] args) {
		String name = "Thirupathamma";
		String[] arr = name.split("");
		Map<String, List<String>> map = Arrays.stream(arr).collect(Collectors.groupingBy(s->s));
		//System.out.println(map);
		Map<String,Long> map1 = Arrays.stream(name.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		//System.out.println(map1);
		
		// Java program to find all duplicate elements from a given string
		List<String> list = Arrays.stream(name.split(""))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream()
		.filter(s->s.getValue()>1)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());
		//System.out.println(list);
		
		// find all unique elements
		List<String> uniqueList = Arrays.stream(name.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.filter(s->s.getValue()==1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
				//System.out.println(uniqueList);
		
		//Java program to find first non-repeat element from a given string
		
				String value = Arrays.stream(name.split(""))
						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
						.entrySet().stream()
						.filter(s->s.getValue()==1)
						.findFirst().get().getKey();
				//System.out.println(value);
		// skip() & Limit()
				
				List<String> uniqueList1 = Arrays.stream(name.split(""))
						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
						.entrySet().stream()
						.filter(s->s.getValue()==1)
						.map(Map.Entry::getKey).skip(1).limit(3)
						.collect(Collectors.toList());
						//System.out.println(uniqueList1);
						
		//Java program to find second highest number from given array
						int[] numbers = {5,9,12,3,9,21,1,49};
						List<Integer> integerList = Arrays.stream(numbers).boxed()
						.sorted(Comparator.reverseOrder())
						.collect(Collectors.toList());
						System.out.println(integerList);
						
						
						Integer secondHighest = Arrays.stream(numbers).boxed()
						.sorted(Comparator.reverseOrder())
						.skip(1)
						.findFirst().get();
						System.out.println(secondHighest);
						
						//Java program to find longest strig from given array
						String[] array = {"java", ".net", "spring", "Spring Boot", "AngularAngular"};
						
						String longest = Arrays.stream(array).reduce((word1, word2)-> word1.length() > word2.length() ? word1:word2).get();
						System.out.println(longest);
				
				//Java program to find all elements from array who starts with 9
						int[] numbersArr = {5, 55, 45, 98, 87, 34, 91, 9};
						List<String> listStartswith9 = Arrays.stream(numbersArr)
						.boxed()
						.map(s->s+"")
						.filter(x->x.startsWith("9"))
						.collect(Collectors.toList());
						System.out.println(listStartswith9);
						
	}

}
