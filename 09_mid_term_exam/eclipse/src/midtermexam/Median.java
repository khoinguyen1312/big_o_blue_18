package midtermexam;

import java.util.Arrays;
import java.util.Scanner;

public class Median {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int n = argumentScanner.nextInt();
    	
    	int[] array = new int[n];
    	
    	for (int i = 0; i < n; i++) {
    		array[i] = argumentScanner.nextInt();
    	}
    	
    	argumentScanner.close();
    	
    	Arrays.sort(array);
    	
    	System.out.println(array[n/2]);
	}
}
