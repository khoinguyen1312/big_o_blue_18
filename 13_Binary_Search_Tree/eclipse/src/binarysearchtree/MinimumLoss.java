package binarysearchtree;

import java.util.Scanner;

public class MinimumLoss {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int numberOfYears = argumentScanner.nextInt();
    	long[] years = new long[numberOfYears];
    	
    	for (int i = 0; i < numberOfYears; i++) {
    		years[i] = argumentScanner.nextLong();
    	}
    	
    	argumentScanner.close();
    	
    	long min = Long.MAX_VALUE;
    	
    	for (int i = 0; i < numberOfYears; i++) {
    		for (int j = i + 1; j < numberOfYears; j++) {
    			long result =  years[i] - years[j];
    			if (result >= 0 && result < min) {
    				min = result;
    			}
    		}
    	}
    	    	
    	System.out.println(min);	
	}
}
