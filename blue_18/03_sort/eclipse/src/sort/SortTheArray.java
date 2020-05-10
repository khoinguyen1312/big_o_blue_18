package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortTheArray {
	public static void main(String args[]) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int size = argumentScanner.nextInt();
    	
    	List<Integer> numbers = new ArrayList<>(size);
    	
    	for (int i = 0; i < size; i++) {
    		numbers.add(argumentScanner.nextInt());
    	}
    	
    	argumentScanner.close();
		
		isReversable(numbers);
	}
	
	public static void isReversable(List<Integer> numbers) {
		int leftPosition = spotLeftPosition(numbers);
		
		if (leftPosition == -1) {
			System.out.println(false);
			return;
		}
		
		int rightPosition = spotRightPosition(numbers);
		
		if (rightPosition == -1) {
			System.out.println(false);
			return;
		}
		
		reverseIndexList(numbers, leftPosition, rightPosition);

		if (isSorted(numbers)) {
			System.out.println(true);
			System.out.println(leftPosition + " " + rightPosition);
			return;
		}
		
		System.out.println(false);
	}
	
	public static int spotLeftPosition(List<Integer> numbers) {
		for (int i = 0; i < numbers.size() - 1; i++) {
			if (numbers.get(i) > numbers.get(i + 1)) {
				return i;
			}
		}
		
		return -1;
	}

	public static int spotRightPosition(List<Integer> numbers) {
		for (int i = numbers.size() - 1; i >= 1; i--) {
			if (numbers.get(i) < numbers.get(i - 1)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static boolean isSorted(List<Integer> numbers) {
		for (int i = 0; i < numbers.size() - 1; i++) {
			if (numbers.get(i) > numbers.get(i + 1)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void reverseIndexList(List<Integer> numbers, int left, int right) {
		for (int i = left; i < (right + left) / 2; i++) {
			int from = i;
			int to = right - (i - left);
			Integer temp = numbers.get(from);
			numbers.set(from, numbers.get(to));
			numbers.set(to, temp);
		}
	}
}
