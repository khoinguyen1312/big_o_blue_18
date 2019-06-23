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
		
		Founded answer = solution.printSegment(0, numbers.size() - 1);
		
		if (answer == null) {
			System.out.println("-1 -1");
			return;
		}
		
		System.out.println((answer.from + 1) + " " + (answer.to + 1));
	}
	
	List<Integer> numbers;
	int k;
	
	private class Founded {
		int from;
		int to;
		
		Founded(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	
	Array(List<Integer> numbers, int k) {
		this.numbers = new ArrayList<>(numbers);
		this.k = k;
	}
	
	public Founded printSegment(int from, int to) {
		if (to - from + 1 < k) {
			return null;
		}
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = from; i <= to; i++) {
			set.add(numbers.get(i));
		}

		if (set.size() >= k) {
			Founded right = printSegment(from, to - 1);
			Founded left = printSegment(from + 1, to);
			if (right != null) {
				return right;
			}
			if (left != null) {
				return left;
			}
			if (set.size() == k) {
				return new Founded(from, to);
			}
		}
		return null;
	}
}
