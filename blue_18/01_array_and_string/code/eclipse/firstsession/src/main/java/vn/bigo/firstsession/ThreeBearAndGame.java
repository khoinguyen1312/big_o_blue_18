package vn.bigo.firstsession;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreeBearAndGame {
	
	private static int MINUTES_GAME_LAST = 90;
	private static int CONTINIOUS_BORING_MINUTES_WILL_TURN_OFF = 15;
	
	
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int numberOfInterestingMinutes = argumentScanner.nextInt();
    	
    	List<Integer> interestingMinutes = new ArrayList<Integer>(numberOfInterestingMinutes);
    	
    	for (int i = 0; i < numberOfInterestingMinutes; i++) {
    		interestingMinutes.add(argumentScanner.nextInt());
    	}
    	
    	argumentScanner.close();
    	
    	System.out.println(calculateMinutesWatching(interestingMinutes));
	}
	
	public static int calculateMinutesWatching(List<Integer> interestingMinutes) {	
		int currentMinute = 0;
		
		for (int nextInterestingMinute : interestingMinutes) {
			if (nextInterestingMinute - currentMinute > CONTINIOUS_BORING_MINUTES_WILL_TURN_OFF) {
				return currentMinute + CONTINIOUS_BORING_MINUTES_WILL_TURN_OFF;
			}
			currentMinute = nextInterestingMinute;
		}
		
		if (MINUTES_GAME_LAST - currentMinute > CONTINIOUS_BORING_MINUTES_WILL_TURN_OFF) {
			return currentMinute + CONTINIOUS_BORING_MINUTES_WILL_TURN_OFF;
		}
		
		return MINUTES_GAME_LAST;
	}
}
