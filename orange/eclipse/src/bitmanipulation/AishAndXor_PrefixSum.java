package bitmanipulation;

import java.util.Scanner;

public class AishAndXor_PrefixSum {
	// input
	//	5
	//	1 0 0 0 1
	//	3
	//	2 4
	//	1 5
	//	3 5
	
	// output
	//	0 3
	//	0 3
	//	1 2
	
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int sizeOfArray = argumentScanner.nextInt();
    	int[] array = new int[sizeOfArray];
    	
    	for (int i = 0 ; i < sizeOfArray; i++) {
    		array[i] = argumentScanner.nextInt();
    	}


    	int[] countOne = new int[sizeOfArray];
    	if (array[0] == 1) {
    		countOne[0] = 1;
    	} else {
    		countOne[0] = 0;
    	}
    	
    	for (int i = 1; i < sizeOfArray; i++) {
    		countOne[i] = countOne[i - 1] + array[i];
    	}
    	
    	int numberOfQuery = argumentScanner.nextInt();
    	
    	for (int i = 0; i < numberOfQuery; i++) {
    		int left = argumentScanner.nextInt() - 1;
    		int right = argumentScanner.nextInt() - 1;
    		
    		int numberOfNumberOneFromLeftToRight;
    		if (left == 0) {
    			numberOfNumberOneFromLeftToRight = countOne[right];
    		} else {
    			numberOfNumberOneFromLeftToRight = countOne[right] - countOne[left - 1];
    		}
    		
    		int numberOfZeroNumber = right - left + 1 - numberOfNumberOneFromLeftToRight;
    		
    		if (numberOfNumberOneFromLeftToRight % 2 == 1) {
    			System.out.println("1 " + numberOfZeroNumber);
    		} else {
    			System.out.println("0 " + numberOfZeroNumber);
    		}
    		
    	}
    	
    	argumentScanner.close();
	}
}
