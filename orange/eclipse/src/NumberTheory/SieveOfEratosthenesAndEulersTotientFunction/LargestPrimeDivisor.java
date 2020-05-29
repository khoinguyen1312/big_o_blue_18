package NumberTheory.SieveOfEratosthenesAndEulersTotientFunction;

import java.util.Scanner;

public class LargestPrimeDivisor {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);

		int n = argumentScanner.nextInt();
		
		while (n != 0) {
			System.out.println(phiLargestOfN(n));
			n = argumentScanner.nextInt();
		}
		
		argumentScanner.close();
	}
	
	private static int gcd(int a, int b) {
		int reminder;
		
		while (b != 0) {
			reminder = a % b;
			a = b;
			b = reminder;
		}
		
		return a;
	}


	private static int phiLargestOfN(int n) {
		int max = -1;
		
		for (int i = 2; i < n; i++) {
			if (gcd(i, n) == i) {
				max = i;
			}
		}
		
		return max;
	}

//	private static int[] findAllPrimesBelowAndNotGcdOfN(int n) {
//		int[] primeMap = new int[n + 1]; 
//		
//		for (int i = 0; i <= n; i++) {
//			primeMap[i] = 1;
//		}
//		
//		primeMap[0] = -1;
//		primeMap[1] = -1;
//		
//		for (int i = 2; i * i <= n; i++) {
//			if (primeMap[i] == 1) {
//				for (int j = i + i; j <= n; j += i) {
//					primeMap[j] = i;
//				}
//				primeMap[i] = -1;
//			}
//		}
//		
//		return primeMap;
//	}
}
