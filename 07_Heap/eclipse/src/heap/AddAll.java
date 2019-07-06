package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AddAll {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);

    	int nextArgument = argumentScanner.nextInt();
    	
    	while (nextArgument != 0) {
			int numberOfNumbers = nextArgument;
			
			List<Long> numbers = new ArrayList<>();
			
			for (int i = 0; i < numberOfNumbers; i++) {
				numbers.add(argumentScanner.nextLong());
			}
			
			System.out.println(costCalulation(numbers));
			
			nextArgument = argumentScanner.nextInt();
    	}
    	
		argumentScanner.close();
	}
	
	public static long costCalulation(List<Long> numbers) {
		Collections.sort(numbers);
		List<Long> array = new ArrayList<>();
		
		array.add(numbers.get(0));
		
		for (int i = 1; i < numbers.size(); i++) {
			array.add(array.get(i - 1) + numbers.get(i));
		}
		
		return array.subList(1, array.size()).stream().mapToLong(Long::valueOf).sum();
	}
}
