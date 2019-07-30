package binarysearch;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Eko {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int numberOfTrees = argumentScanner.nextInt();
    	int requiredWood = argumentScanner.nextInt();
    	int[] trees = new int[numberOfTrees]; 
    	
    	for (int i = 0; i < numberOfTrees; i++) {
    		trees[i] = argumentScanner.nextInt();
    	}
    	
    	argumentScanner.close();
    	
    	System.out.println(calculateHeight(trees, requiredWood));
	}
	
	public static int calculateHeight(int[] trees, int requiredWood) {
		trees = IntStream.of(trees).mapToObj(Integer::valueOf).sorted((v1, v2) -> v2.compareTo(v1)).mapToInt(v -> v).toArray();
		
		int maxTreeHeight = IntStream.of(trees).max().getAsInt();
		
		int[] divied = new int[trees.length];
		
		for (int i = 0; i < trees.length; i++) {
			divied[i] = 0;
		}
		
		for (int i = 0; i < trees.length; i++) {
			for (int j = 0; j <= i; j++) {
				divied[i] += trees[j] - trees[i];
			}
		}
		
		int upperBound = BinarySearchBound.createInstance(divied, 0, divied.length, requiredWood).findUpperBound();
		
		int lowerBound = upperBound - 1;
		
		int a = ((requiredWood - divied[lowerBound]) / upperBound);
		int result = a * upperBound + lowerBound;
		return result;
	}
}
