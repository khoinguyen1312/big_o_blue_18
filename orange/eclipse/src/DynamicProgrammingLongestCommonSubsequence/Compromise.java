package DynamicProgrammingLongestCommonSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Compromise {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	while (argumentScanner.hasNext()) {
	    	
	    	List<String> firstSentence = new ArrayList<>();
	    	List<String> secondSentence = new ArrayList<>();
	    	
	    	String nextWord = argumentScanner.next();
	    	
	    	while (!nextWord.equals("#")) {
	    		firstSentence.add(nextWord);
	    		nextWord = argumentScanner.next();
	    	}
	    	nextWord = argumentScanner.next();
	    	while (!nextWord.equals("#")) {
	    		secondSentence.add(nextWord);
	    		nextWord = argumentScanner.next();
	    	}
	    	
	    	List<String> result = (new CommonLcs<String>(firstSentence, secondSentence)).printLCS();
	    	    	
	    	System.out.println(
	    			String.join(" ", result)
	    			);
    	}
    	
    	argumentScanner.close();
	}

}

class CommonLcs<T> {
	public int[][] L;
	
	private List<T> l1;	
	private List<T> l2;
	
	public CommonLcs(List<T> l1, List<T> l2) {
		this.l1 = l1;
		this.l2 = l2;
		this.L = new int[l1.size()][l2.size()];
		
		for (int[] row : L) {
			Arrays.fill(row, -1);
		}
		
		lcs(l1.size(), l2.size());
	}
	
	public int lcsScore() {
		return L[l1.size() - 1][l2.size() - 1];
	}
	
	public List<T> printLCS() {
		List<T> result = new ArrayList<>();
		
		int i = l1.size() - 1, j = l2.size() - 1;
		
		while (i >= 0 && j >= 0) {
			if (l1.get(i).equals(l2.get(j))) {
				result.add(l1.get(i));
				i--;
				j--;
			} else if (i == 0) {
				j--;
			} else if (j == 0) {
				i--;
			} else if (L[i - 1][j] > L[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		
		Collections.reverse(result);
		
		return result;
	}
	
	private int lcs(int l1Counter, int l2Counter) {
		if (l1Counter == 0 || l2Counter == 0) {
			return 0;
		}
		
		if (L[l1Counter - 1][l2Counter - 1] != -1) {
			return L[l1Counter - 1][l2Counter - 1];
		}
		
		if (l1.get(l1Counter - 1).equals(l2.get(l2Counter - 1))) {
			L[l1Counter - 1][l2Counter - 1] = 1 + this.lcs(l1Counter - 1, l2Counter - 1);
			return L[l1Counter - 1][l2Counter - 1];
		} else {
			L[l1Counter - 1][l2Counter - 1] = Math.max(
					this.lcs(l1Counter, l2Counter - 1), 
					this.lcs(l1Counter - 1, l2Counter)
					);
			return L[l1Counter - 1][l2Counter - 1];
		}
	}

}
