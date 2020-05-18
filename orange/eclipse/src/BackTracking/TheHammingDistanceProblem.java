package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TheHammingDistanceProblem {

	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int numberOfTestSet = argumentScanner.nextInt();
		
		for (int i = 0; i < numberOfTestSet; i++) {
			int numberOfBits = argumentScanner.nextInt();
			int hammingDistance = argumentScanner.nextInt();
			
			Set<Integer> numberOneLocation = new HashSet<>();
			
			findSolution(numberOfBits, hammingDistance, numberOneLocation, 0);
		}
		
		argumentScanner.close();
	}

	private static void findSolution(int numberOfBits, int hammingDistance, Set<Integer> numberOneLocation, int left) {
		if (numberOneLocation.size() == hammingDistance) {
			System.out.println(numberOneLocation);
		} else {
			for (int i = left; i < numberOfBits; i++) {
				numberOneLocation.add(i);
				findSolution(numberOfBits, hammingDistance, numberOneLocation, i + 1);
				numberOneLocation.remove(i);
			}
		}
	}
}
