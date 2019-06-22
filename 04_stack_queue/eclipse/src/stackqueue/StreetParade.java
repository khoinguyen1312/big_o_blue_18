package stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StreetParade {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int nextArgument = argumentScanner.nextInt();
    	
    	while (nextArgument != 0) {
	    	int numberOfTruck = nextArgument;
	    	List<Integer> trucks = new ArrayList<>(numberOfTruck);
	    	
	    	for (int i = 0; i < numberOfTruck; i++) {
	    		trucks.add(argumentScanner.nextInt());
	    	}
	    	
			StreetParade solution = new StreetParade(trucks);
			
			if (solution.isAbleToReAlign()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
			nextArgument = argumentScanner.nextInt();
    	} 
    	
    	argumentScanner.close();
	}
	
	
	
	private List<Integer> trucks;
	private Stack<Integer> sideStreet;
	
	
	StreetParade(List<Integer> trucks) {
		this.trucks = trucks;
		this.sideStreet = new Stack<>();
	}
	
	public boolean isAbleToReAlign() {
		int currentExpected = 1;
		
		for (Integer truck : trucks) {
			while (!sideStreet.empty() && sideStreet.peek() == currentExpected) {
				sideStreet.pop();
				currentExpected++;		
			}
			
			if (truck == currentExpected) {
				currentExpected++;
			} else {
				sideStreet.push(truck);
			}
		}
		
		while (!sideStreet.empty()) {
			if (sideStreet.pop() != currentExpected) {
				return false;
			}
			currentExpected++;
		}
		
		return true;
	}
}
