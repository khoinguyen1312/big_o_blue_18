package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Pizzamania {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int numberOfProblem = argumentScanner.nextInt();
    	
    	for (int problem = 0; problem < numberOfProblem; problem++) {
    		int numberOfFriends = argumentScanner.nextInt();
    		int pizzaPrice = argumentScanner.nextInt();
    		
    		int[] money = new int[numberOfFriends];
    		boolean[] isChecked = new boolean[money.length];
    		
    		for (int i = 0; i < numberOfFriends; i++) {
    			money[i] = argumentScanner.nextInt();
    			isChecked[i] = false;
    		}
    		
    		Arrays.sort(money);
    		
    		int pairCount = 0;
    		
    		for (int i = 0; i < money.length; i++) {
    			int pariedPrice = pizzaPrice - money[i];
    			
    			Integer resultIndex = null;
    			
    			int leftSearch = Arrays.binarySearch(money, 0, i, pariedPrice);
    			
    			if (leftSearch >= 0 && !isChecked[leftSearch] && !isChecked[i]) {
    				resultIndex = leftSearch;
    			} else {
        			int rightSearch = Arrays.binarySearch(money, i + 1, money.length, pariedPrice);
        			
        			if (rightSearch >= 0 && !isChecked[rightSearch] && !isChecked[i]) {
        				resultIndex = rightSearch;
        			}
    			}
    			
    			if (resultIndex != null) {
					pairCount++;
					isChecked[resultIndex] = true;
					isChecked[i] = true;
    			}
    		}
    		
    		System.out.println(pairCount);
    	}
    	
    	argumentScanner.close();
	}
}
