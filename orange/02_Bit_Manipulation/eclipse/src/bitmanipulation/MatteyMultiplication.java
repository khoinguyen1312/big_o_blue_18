package bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class MatteyMultiplication {
	// input
	//	2
	//	2 1
	//	2 3
	
	// output
	//	(2<<0)
	//	(2<<1) + (2<<0)
	
	
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int numberOfQuery = argumentScanner.nextInt();
    	
    	for (int i = 0; i < numberOfQuery; i++) {
    		long leftNumber = argumentScanner.nextLong();
    		long rightNumber = argumentScanner.nextLong();
    		
    		List<String> outputResult = new ArrayList<>();
    		
    		int shiftRightCounter = 0;
    		
    		while (rightNumber != 0) {
    			if ((rightNumber & 1) == 1) {
    				outputResult.add(
    					String.format("(%s<<%s)", leftNumber, shiftRightCounter)
					);
    			}    			
    			rightNumber = rightNumber >> 1;
    			shiftRightCounter++;
    		}
    		
    		Collections.reverse(outputResult);
    		System.out.println(
				String.join(" + ", outputResult)
			);
    	}
    	
    	argumentScanner.close();
	}
}
