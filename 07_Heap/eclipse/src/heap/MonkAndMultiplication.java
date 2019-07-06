package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MonkAndMultiplication {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
	
		int numberOfNumbers = argumentScanner.nextInt();
		
		List<Long> numbers = new ArrayList<>(numberOfNumbers);
		
		for (int i = 0; i < numberOfNumbers; i++) {
			numbers.add(argumentScanner.nextLong());
		}
		
		argumentScanner.close();
		
		printProductOfTreeLargest(numbers);
	}
	
	public static void printProductOfTreeLargest(List<Long> numbers) {
		if (numbers.size() < 3) {
			for (int i = 0; i < numbers.size(); i++) {
				System.out.println("-1");
			}
			return;
		}
		
		if (numbers.size() == 3) {
			System.out.println("-1");
			System.out.println("-1");
			System.out.println(numbers.get(0) * numbers.get(1) * numbers.get(2));
			return;
		}

		System.out.println("-1");
		System.out.println("-1");
		System.out.println(numbers.get(0) * numbers.get(1) * numbers.get(2));
		
		Long[] maxes = new Long[4];
		maxes[0] = numbers.get(0);
		maxes[1] = numbers.get(1);
		maxes[2] = numbers.get(2);
		maxes[3] = numbers.get(3);
		
		Arrays.sort(maxes);
		
		System.out.println(maxOfLastIndex(maxes));
		
		for (int i = 4; i < numbers.size(); i++) {
			Long nextNumber = numbers.get(i);
			if (nextNumber > maxes[0]) {
				maxes[0] = nextNumber;
			}

			Arrays.sort(maxes);
			System.out.println(maxOfLastIndex(maxes));
		}
	}
	
	public static long maxOfLastIndex(Long[] maxes) {
		return maxes[3] * maxes[2] * maxes[1];
	}
}
