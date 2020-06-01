package MidTerm;

import java.util.Scanner;

public class PalindromicSeries {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int T = argumentScanner.nextInt();
		
		for (int i = 0; i < T; i++) {
			String N = argumentScanner.next();
			
			int totalPrintCharacter = 0;
			
			for (char c : N.toCharArray()) {
				totalPrintCharacter += Integer.parseInt(String.valueOf(c));
			}
			
			boolean isPalindromic = false;
			
			if (totalPrintCharacter < N.length()) {
				isPalindromic = isPalindromic(N.substring(0, totalPrintCharacter));
			} else if (totalPrintCharacter == N.length()) {
				isPalindromic = isPalindromic(N);
			} else {
				String calculated = N + N.substring(0, (totalPrintCharacter % N.length()));

				isPalindromic = isPalindromic(calculated);
			}
			
			if (isPalindromic) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		argumentScanner.close();
	}
	
	public static boolean isPalindromic(String a) {
		char[] array = a.toCharArray();
		
		for (int i = 0; i < array.length / 2; i++) {
			if (array[i] != array[array.length - 1 - i]) {
				return false;
			}
		}
		
		return true;
	}
}
