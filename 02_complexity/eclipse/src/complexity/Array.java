package complexity;

import java.util.ArrayList;
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
		Set<Integer> set = new HashSet<>(numbers);
		if (set.size() < k) {
			System.out.println("-1 -1");
			return;
		}

		
		int from = 0;
		int to = 0;

		set = new HashSet<>(numbers.subList(from, to + 1));

		while (to < numbers.size()) {
			if (set.size() == k) {
				break;
			}
			to++;
			set.add(numbers.get(to));
		}
		
		from = to;
		set = new HashSet<>(numbers.subList(from, to + 1));
		
		while (from > 0) {
			if (set.size() == k) {
				break;
			}
			from--;
			set.add(numbers.get(from));
		}
		
		System.out.println((from + 1) + " " + (to + 1));
	}
}
