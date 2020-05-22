package NumberTheory.ModularArithMetic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DrazilAndHisHappyFriends {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);

		int numberOfBoys = argumentScanner.nextInt();
		int numberOfGirls = argumentScanner.nextInt();
		
		int numberOfFunBoys = argumentScanner.nextInt();
		Set<Integer> funBoys = new HashSet<>();
		for (int i = 0; i < numberOfFunBoys; i++) {
			funBoys.add(argumentScanner.nextInt());
		}
		
		int numberOfFunGirls = argumentScanner.nextInt();
		Set<Integer> funGirls = new HashSet<>();
		for (int i = 0; i < numberOfFunGirls; i++) {
			funGirls.add(argumentScanner.nextInt());
		}
		
		argumentScanner.close();
		
		for (int i = 0; i < numberOfBoys * numberOfGirls; i++) {
			int checkingBoy = i % numberOfBoys;
			int checkingGirl = i % numberOfGirls;
			
			if (funBoys.contains(checkingBoy) || funGirls.contains(checkingGirl)) {
				funBoys.add(checkingBoy);
				funGirls.add(checkingGirl);
			}
			
			if (funBoys.size() + funGirls.size() == numberOfBoys + numberOfGirls) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");
	}
}
