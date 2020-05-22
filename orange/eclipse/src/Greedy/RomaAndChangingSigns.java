package Greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RomaAndChangingSigns {
	
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);

		int n = argumentScanner.nextInt();
		int k = argumentScanner.nextInt();
		
		if (n == 1) {
			int result = argumentScanner.nextInt();
			argumentScanner.close();
			
			if (k % 2 != 0) {
				result = 0 - result;
			} 
			System.out.println(result);
			return;
		}
		
		
		int[] numbers = new int[n];
		
		for (int i = 0; i < n; i++) {
			numbers[i] = argumentScanner.nextInt();
		}
		
		argumentScanner.close();
		
		Arrays.sort(numbers);
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] >= 0) {
				break;
			}
			
			numbers[i] = 0 - numbers[i]; 
			k--;
			
			if (k <= 0) {
				break;
			}
		}
		
		if (k > 0) {
			if (k % 2 != 0) {
				int minBetweenPreviousNegativeNumberWithCurrentIndex = IntStream.of(numbers).min().getAsInt();

				System.out.println(IntStream.of(numbers).sum() - minBetweenPreviousNegativeNumberWithCurrentIndex * 2);
				
				return;
			}
		}
			
		System.out.println(IntStream.of(numbers).sum());
	}
}
