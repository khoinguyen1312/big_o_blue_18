//package complexity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * B. George and Round
 * https://codeforces.com/problemset/problem/387/B
 * @author nguyenphan
 */

public class GeorgeAndRound {
	public static void main(String args[]) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int numberOfRequireProblem = argumentScanner.nextInt();
    	int numberOfPreparedProblem = argumentScanner.nextInt();
    	int maximumOfComplexityOfRequiredProblems = 0;
    	
    	Set<Integer> requiredProblems = new HashSet<>();
    	
    	for (int i = 0; i < numberOfRequireProblem; i++) {
    		int requiredProblem = argumentScanner.nextInt();
    		
    		requiredProblems.add(requiredProblem);
    		
    		if (requiredProblem > maximumOfComplexityOfRequiredProblems) {
    			maximumOfComplexityOfRequiredProblems = requiredProblem;
    		}
    	}
    	
    	List<Integer> preparedProblems = new ArrayList<>();
    	
    	for (int i = 0; i < numberOfPreparedProblem; i++) {
    		preparedProblems.add(argumentScanner.nextInt());
    	}
    	
    	argumentScanner.close();
    	
    	int needToPrepareProblems = numberOfRequireProblem;
    	
    	for (Integer preparedProblem : preparedProblems) {
    		if (requiredProblems.contains(preparedProblem)) {
    			requiredProblems.remove(preparedProblem);
    			needToPrepareProblems--;
    		} else if (preparedProblem > maximumOfComplexityOfRequiredProblems) {
    			needToPrepareProblems--;
    		}
    		
    		if (needToPrepareProblems == 0) {
    			break;
    		}
    	}
    	
    	System.out.println(needToPrepareProblems);
    	
    	System.exit(0);
	}
}
