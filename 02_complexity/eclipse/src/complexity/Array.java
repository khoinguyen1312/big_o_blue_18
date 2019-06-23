package complexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Array {
	public static void main(String args[]) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int size = argumentScanner.nextInt();
    	int k = argumentScanner.nextInt();
    	
    	List<Integer> numbers = new ArrayList<>(size);
    	
    	for (int i = 0; i < size; i++) {
    		numbers.add(argumentScanner.nextInt());
    	}
    	
    	argumentScanner.close();
		
		Array solution = new Array(numbers, k);
		
		solution.printSegment();
	}
	
	List<Integer> numbers;
	int k;
	
	Array(List<Integer> numbers, int k) {
		this.numbers = new ArrayList<>(numbers);
		this.k = k;
	}
	
	public void printSegment() {
		for (int i = k; i <= numbers.size(); i++) {
			int from = 0;
			int to = k - 1;
			while (to < numbers.size()) {
		
				Set<Integer> set = new HashSet<>();
				for (int j = from; j <= to; j++) {
					set.add(numbers.get(j));
				}
				
				if (set.size() == k) {
					System.out.println((from + 1) + " " + (to + 1));
					return;
				}
				from++;
				to++;
			}
		}
		System.out.println("-1 -1");
	}
}
