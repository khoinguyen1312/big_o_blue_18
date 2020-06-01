package MidTerm;

import java.util.Scanner;

public class PoloThePenguinAndTheXor {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);

		int numberOfProblem = argumentScanner.nextInt();
		
		for (int problemCounter = 0; problemCounter < numberOfProblem; problemCounter++) {
			int N = argumentScanner.nextInt();
			int[] numbers = new int[N];
			
			for (int i = 0; i < N; i++) {
				numbers[i] = argumentScanner.nextInt();
			}
			
			long result = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					result += xor(numbers, i, j);
				}
			}
			
			System.out.println(result);
		}
		
		argumentScanner.close();
	}
	
	public static int xor(int[] array, int left, int right) {
		int result = 0;
		for (int i = left; i <= right; i++) {
			result = result ^ array[i];
		}
		
		return result;
	}
}
