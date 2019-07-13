package midtermexam;

import java.util.Scanner;

public class SoldierAndBananas {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	int k = argumentScanner.nextInt();
    	int n = argumentScanner.nextInt();
    	int w = argumentScanner.nextInt();
    	argumentScanner.close();
    	
		System.out.println(moneyHaveToBorrow(k, n, w));
	}
	
	public static int moneyHaveToBorrow(int k, int dollars, int numberOfBananaWantToBuy) {
		int moneyHaveToPayForAllBanana = 0;
		
		for (int i = 1; i <= numberOfBananaWantToBuy; i++) {
			moneyHaveToPayForAllBanana += k * i;
		}
		
		if (dollars >= moneyHaveToPayForAllBanana) {
			return 0;
		}
		
		return moneyHaveToPayForAllBanana - dollars;
	}
}
