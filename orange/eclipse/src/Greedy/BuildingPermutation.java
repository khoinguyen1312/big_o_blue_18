package Greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BuildingPermutation {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);

		int n = argumentScanner.nextInt();
		
		int[] currentArray = new int[n];
		
		for (int i = 0; i < n; i++) {
			currentArray[i] = argumentScanner.nextInt();
		}
		
		List<Integer> duplicatedOrNegativeOrBiggerThanN = new ArrayList<>();
		
		argumentScanner.close();
		
		Set<Integer> positiveNumbers = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			if (currentArray[i] > 0 && currentArray[i] <= n && !positiveNumbers.contains(currentArray[i])) {
				positiveNumbers.add(currentArray[i]);
			} else {
				duplicatedOrNegativeOrBiggerThanN.add(currentArray[i]);
			}
		}
		
		List<Integer> lackingOfPositiveNumbers = new ArrayList<>();
		
		duplicatedOrNegativeOrBiggerThanN.sort(Integer::compareTo);
		
		for (int i = 1; i <= n; i++) {
			if (!positiveNumbers.contains(i)) {
				lackingOfPositiveNumbers.add(i);
			}
		}
		
		long result = 0;
		
		for (int i = 0; i < lackingOfPositiveNumbers.size(); i++) {
			result += Math.abs(lackingOfPositiveNumbers.get(i) - duplicatedOrNegativeOrBiggerThanN.get(i));
		}
		
		System.out.println(result);
	}
}
