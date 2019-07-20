package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class WhereIsTheMarble {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);

    	int firstNumber = argumentScanner.nextInt();
    	int secondNumber = argumentScanner.nextInt();
    	
    	int problemIndex = 0;
    	
    	while (firstNumber != 0 && secondNumber != 0) {
    		int numberOfMarbles = firstNumber;
    		int numberOfQuerries = secondNumber;
    		
    		problemIndex++;
    		System.out.println("CASE# " + problemIndex + ":");
    		
    		int[] marbles = new int[numberOfMarbles];
    		
    		for (int i = 0; i < numberOfMarbles; i++) {
    			marbles[i] = argumentScanner.nextInt();
    		}
    		
    		
    		int[] querries = new int[numberOfQuerries];
    		
    		for (int i = 0; i < numberOfQuerries; i++) {
    			querries[i] = argumentScanner.nextInt();
    		}
    		
    		Arrays.sort(marbles);
    		
    		for (int query : querries) {
    			int resultIndex = BinarySearchBound.createInstance(marbles, 0, numberOfMarbles - 1, query - 1).findUpperBound();
    			
    			if (marbles[resultIndex] != query) {
    				System.out.println(query + " not found");
    			} else {
    				System.out.println(query + " found at " + (resultIndex + 1));
    			}
    		}
    		
    		
    		try {
	        	firstNumber = argumentScanner.nextInt();
	        	secondNumber = argumentScanner.nextInt();
    		} catch (Exception e) {
    			break;
			}
    	}
    	
    	argumentScanner.close();
	}
}
