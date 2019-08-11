package finalexam;

import java.util.Scanner;

public class FibsieveFantabulous {
	static class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return this.x + " " + this.y;
		}
	}
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int numberOfTest = argumentScanner.nextInt();
		
		for (int i = 0; i < numberOfTest; i++) {
			System.out.println("Case " + (i + 1) + ": " + solution(argumentScanner.nextInt()));
		}
		
		argumentScanner.close();
	}
	private static String solution(int number) {
		if (number == 1) {
			return "1 1";
		}
		
		int currentBoundary = 1;
		
		int counter = 1;
		
		boolean turn = true;
		
		counter++;
		
		
		while (counter <= number) {
			currentBoundary++;
			if (turn) {
				for (int i = 1; i < currentBoundary; i++) {
					if (counter == number) {
						return i + " " + currentBoundary;
					}
					counter++;
				}
				
				if (counter == number) {
					return currentBoundary + " " + currentBoundary;
				}
				counter++;

				for (int i = currentBoundary - 1; i >= 1; i--) {
					if (counter == number) {
						return currentBoundary + " " + i;
					}
					counter++;
				}
			} else {
				for (int i = 1; i < currentBoundary; i++) {
					if (counter == number) {
						return currentBoundary + " " + i;
					}
					counter++;
				}

				if (counter == number) {
					return currentBoundary + " " + currentBoundary;
				}
				counter++;

				for (int i = currentBoundary - 1; i >= 1; i--) {
					if (counter == number) {
						return i + " " + currentBoundary;
					}
					counter++;
				}
			}
			
			turn = !turn;
		}
		
		return "";
	}
}
