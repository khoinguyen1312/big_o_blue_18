package vn.bigo.firstsession;

import java.util.Scanner;

public class TwoNightAtMuseum {
	private static int NUMBER_OF_CHARACTER = 'z' - 'a' + 1;
	
	
	public static void main(String[] argus) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	String name = argumentScanner.nextLine();
    	
    	argumentScanner.close();
		
		char[] characters = ("a" + name).toCharArray();
		
		int count = 0;
		
		for (int i = 0; i < characters.length - 1; i++) {
			count = count + countMinimumStep(characters[i], characters[i+1]);
		}
		
		System.out.println(count);
	}
	
	public static int countMinimumStep(char currentCharacter, char goingToCharacter) {
		int clockWiseSteps = countClockWiseStep(currentCharacter, goingToCharacter);
		int counterClockWiseSteps = countCounterClockWiseStep(currentCharacter, goingToCharacter);
		
		//System.out.println(currentCharacter + "-> " + goingToCharacter + ": " + clockWiseSteps + " " + counterClockWiseSteps);
		
		if (clockWiseSteps <= counterClockWiseSteps) {
			return clockWiseSteps;
		}
		
		return counterClockWiseSteps;
	}
	
	public static int countClockWiseStep(char currentCharacter, char goingToCharacter) {
		int result = goingToCharacter - currentCharacter;
		if (result < 0) {
			result += NUMBER_OF_CHARACTER;
		}
		
		return result;
	}
	

	public static int countCounterClockWiseStep(char currentCharacter, char goingToCharacter) {
		int result = currentCharacter - goingToCharacter;
		if (result < 0) {
			result += NUMBER_OF_CHARACTER;
		}
		
		return result;
	}
}
