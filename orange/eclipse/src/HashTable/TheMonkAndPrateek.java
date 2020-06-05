package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TheMonkAndPrateek {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int numberOfNumbers = argumentScanner.nextInt();
		
		int[] numbers = new int[numberOfNumbers];
		
		for (int i = 0; i < numberOfNumbers; i++) {
			numbers[i] = argumentScanner.nextInt();
		}
		
		argumentScanner.close();
		
		Map<Integer, Integer> hashTable = new HashMap<>();
		
		int mostHashCount = 1;
		int mostHashNumber = 0;
		
		int maxHasedValue = 0;
		
		
		for (int i : numbers) {
			int hashed = hash(i);
			
			if (maxHasedValue < hashed) {
				maxHasedValue = hashed;
			}
			
			if (!hashTable.containsKey(hashed)) {
				hashTable.put(hashed, 1);
			} else {
				int newHashedCount = hashTable.get(hashed) + 1;
				hashTable.put(hashed, newHashedCount);
				
				if (mostHashCount < newHashedCount) {
					mostHashCount = newHashedCount;
					mostHashNumber = hashed;
				}
			}
		}
		
		if (mostHashCount == 1) {
			System.out.println(maxHasedValue + " " + 0);
		} else {
			System.out.println(mostHashNumber + " " + (mostHashCount - 1));
		}
	}
	
	public static int hash(int number) {
		char[] digits = String.valueOf(number).toCharArray();
		
		int digitSum = 0;
		
		for (char c : digits) {
			digitSum += Integer.parseInt(String.valueOf(c));
		}
		
		return number ^ digitSum;
	}
	
}