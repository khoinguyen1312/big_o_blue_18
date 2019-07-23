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
		int maxTreeHeight = IntStream.of(trees).max().getAsInt();
		int[] woodByHeight = new int[maxTreeHeight + 1];
		
		for (int i = 0; i <= maxTreeHeight; i++) {
			final int cutHeight = i;
			woodByHeight[maxTreeHeight - i] = 
					IntStream.of(trees).map(treeHeight -> {
						if (cutHeight >= treeHeight) {
							return 0;
						} 
						return treeHeight - cutHeight;
					}).sum();
		}
		
		int resultIndex = Arrays.binarySearch(woodByHeight, requiredWood);
		
		if (resultIndex < 0) {
			int insertPoint = - resultIndex - 1;
			return maxTreeHeight - insertPoint;
		} else {
			return maxTreeHeight - resultIndex;
		}
	}
}
