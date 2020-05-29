package NumberTheory.SieveOfEratosthenesAndEulersTotientFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IrreducibleBasicFractions {
	
	// Function Phi euler
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);

		int n = argumentScanner.nextInt();
		
		while (n != 0) {
			List<Integer> primes = findAllPrimesBelowAndNotGcdOfN(n);
			
			System.out.println(primes.size() - 1);
			n = argumentScanner.nextInt();
		}
		
		argumentScanner.close();
	}

	private static List<Integer> findAllPrimesBelowAndNotGcdOfN(int n) {
		boolean[] isPrimeNumbers = new boolean[n]; 
		
		for (int i = 0; i < n; i++) {
			isPrimeNumbers[i] = true;
		}
		
		isPrimeNumbers[0] = false;
		isPrimeNumbers[1] = false;
		
		for (int i = 2; i * i < n; i++) {
			if (isPrimeNumbers[i] == true) {
				for (int j = i * i; j < n; j += i) {
					isPrimeNumbers[j] = false;
				}
			}
		}
		
		List<Integer> primes = new ArrayList<>();
		primes.add(0);
		primes.add(1);
		
		for (int i = 0; i < isPrimeNumbers.length; i++) {
			if (isPrimeNumbers[i]) {
				primes.add(i);
			}
		}
		
		return primes;
	}
}
