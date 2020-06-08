package DynamicProgrammingLongestCommonSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CrossCountry {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int d = argumentScanner.nextInt();
    	
    	for (int problemCounter = 0; problemCounter < d; problemCounter++) {
    		List<Integer> agnesRoute = new ArrayList<>();
    		
    		int nextNumber = argumentScanner.nextInt();
    		
    		while (nextNumber != 0) {
    			agnesRoute.add(nextNumber);
    			
    			nextNumber = argumentScanner.nextInt();
    		}
    		
    		List<List<Integer>> tomRoutes = new ArrayList<>();

    		nextNumber = argumentScanner.nextInt();
    		while (nextNumber != 0) {
    			List<Integer> newRoute = new ArrayList<>();
        		while (nextNumber != 0) {
        			newRoute.add(nextNumber);
        			nextNumber = argumentScanner.nextInt();
        		}
        		tomRoutes.add(newRoute);
    			nextNumber = argumentScanner.nextInt();
    		}
    		
    		int maxRouteCount = 0;
    		
    		for (List<Integer> route : tomRoutes) {
    			int scoreOfThisRoute = (new LCS(agnesRoute, route)).lcsScore();
    			
    			if (scoreOfThisRoute > maxRouteCount) {
    				maxRouteCount = scoreOfThisRoute;
    			}
    		}
    		
    		System.out.println(maxRouteCount);
    		
    	}
    	argumentScanner.close();
	}
	
}

class LCS {
	public int[][] L;
	
	private List<Integer> l1;	
	private List<Integer> l2;
	
	public LCS(List<Integer> l1, List<Integer> l2) {
		this.l1 = l1;
		this.l2 = l2;
		this.L = new int[l1.size()][l2.size()];
		
		for (int[] row : L) {
			Arrays.fill(row, -1);
		}
	}
	
	public int lcsScore() {
		return lcs(l1.size(), l2.size());
	}
	
	private int lcs(int l1Counter, int l2Counter) {
		if (l1Counter == 0 || l2Counter == 0) {
			return 0;
		}
		
		if (L[l1Counter - 1][l2Counter - 1] != -1) {
			return L[l1Counter - 1][l2Counter - 1];
		}
		
		if (l1.get(l1Counter - 1) == l2.get(l2Counter - 1)) {
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
