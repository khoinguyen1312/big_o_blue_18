package vn.bigo.firstsession;

import java.util.Arrays;
import java.util.List;

public class ThreeBearAndGame {
	
	private static int MINUTES_GAME_LAST = 90;
	private static int CONTINIOUS_BORING_MINUTES_WILL_TURN_OFF = 15;
	
	
	public static void main(String[] args) {
		System.out.println(calculateMinutesWatching(Arrays.asList(7, 20, 88)));
		//35
	}
	
	public static int calculateMinutesWatching(List<Integer> interestingMinuteFlag) {
		int i = 0;
		
		int currentMinute = 0;
		int nextInterestingMinute = interestingMinuteFlag.get(0);
		
		while (i < interestingMinuteFlag.size()) {
			if (nextInterestingMinute - currentMinute > CONTINIOUS_BORING_MINUTES_WILL_TURN_OFF) {
				
			}
			
			i++;
		}
		
	}
}
