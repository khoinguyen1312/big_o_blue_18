package NumberTheory.ModularArithMetic;

import java.util.Scanner;

public class BoxesOfChocolates {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);

		int T = argumentScanner.nextInt();
		
		for (int problemCounter = 0; problemCounter < T; problemCounter++) {
			int N = argumentScanner.nextInt();
			int B = argumentScanner.nextInt();
			
			int remainingChocolateForKitty = 0;
			for (int i = 0; i < B; i++) {
				int K = argumentScanner.nextInt();
				
				int[] smallBoxDeception = new int[K];
				for (int j = 0;j < K; j++) {
					smallBoxDeception[j] = argumentScanner.nextInt() % N;
				}
				
				int firstMod = 1;
				for (int j = 0;j < K; j++) {
					firstMod = (firstMod * smallBoxDeception[j]) % N;
				}
				 
				
				int remainingChocolateForKittyAtThisBox = firstMod % N;
				
				remainingChocolateForKitty += remainingChocolateForKittyAtThisBox;
			}
			
			System.out.println(remainingChocolateForKitty % N);
		}
		
		argumentScanner.close();
	}
}
