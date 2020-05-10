package bitmanipulation;

import java.util.Scanner;

public class AishAndXor {
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
    	
    	int numberOfQuery = argumentScanner.nextInt();
    	
    	for (int i = 0; i < numberOfQuery; i++) {
    		int left = argumentScanner.nextInt() - 1;
    		int right = argumentScanner.nextInt() - 1;
    		
    		compute(array, left, right);
    	}
    	
    	argumentScanner.close();
	}

	private static void compute(int[] array, int left, int right) {
		int result = array[left];
		
		int zeroCount = 0;
		if (array[left] == 0) {
			zeroCount++;
		}
		
		for (int i = left + 1; i <= right; i++) {
			result = result ^ array[i];
    		if (array[i] == 0) {
    			zeroCount++;
    		}
    	}
				
		System.out.println(result + " " + zeroCount);
	}
}
