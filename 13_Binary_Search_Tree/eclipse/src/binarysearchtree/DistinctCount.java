package binarysearchtree;

import java.util.Scanner;
import java.util.TreeSet;

public class DistinctCount {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int numberOfProblem = argumentScanner.nextInt();
    	
    	for (int problem = 0; problem < numberOfProblem; problem++) {
    		int numberOfNumbers = argumentScanner.nextInt();
    		int distinctNumber = argumentScanner.nextInt();
    		
    		int[] numbers = new int[numberOfNumbers];
    		
    		for (int i = 0; i < numberOfNumbers; i++) {
    			numbers[i] = argumentScanner.nextInt();
    		}
    		
    		System.out.println(
    				status(numbers, distinctNumber)
    			);
    	}
    	
    	argumentScanner.close();
	}
	
	public static String status(int[] numbers, int distinctNumber) {
		TreeSet<Integer> set = new TreeSet<>();
		
		for (int number : numbers) {
			set.add(number);
		}
		
		if (set.size() > distinctNumber) {
			return "Average";
		}
		
		if (set.size() == distinctNumber) {
			return "Good";
		}
		
		return "Bad";
	}
}
