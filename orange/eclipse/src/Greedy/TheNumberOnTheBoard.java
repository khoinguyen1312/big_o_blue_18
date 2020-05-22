package Greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TheNumberOnTheBoard {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int k = argumentScanner.nextInt();
		
		String degitsString = argumentScanner.next();
		
		argumentScanner.close();
		
		char[] degitsStringCharArray = degitsString.toCharArray();
		
		int[] degits = new int[degitsStringCharArray.length];
		
		for (int i = 0; i < degitsStringCharArray.length; i++) {
			degits[i] = Integer.parseUnsignedInt(
					String.valueOf(degitsStringCharArray[i])
					);	
		}
		
		int sumAllDegits = IntStream.of(degits).sum();
		int different = k - sumAllDegits;
		
		int[] sortedDegits = Arrays.copyOf(degits, degits.length);
				
		Arrays.sort(sortedDegits);
		
		int counter = 0;
		
		while (different > 0) {
			different = different - (9 - sortedDegits[counter]);
			counter++;
		}
		
		System.out.println(counter);
	}
}
