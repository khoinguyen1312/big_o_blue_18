package Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WineTradingInGergovia {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int numberOfHouse = argumentScanner.nextInt();
		
		while (numberOfHouse != 0) {
			
			int[] house = new int[numberOfHouse];
			
			for (int i = 0; i < numberOfHouse; i++) {
				house[i] = argumentScanner.nextInt();
			}
			
			long amountOfWorkNeededToTransferWine = amountOfWorkNeededToTransferWine(house);
			
			System.out.println(amountOfWorkNeededToTransferWine);
			
			numberOfHouse = argumentScanner.nextInt();
		}
		
		argumentScanner.close();
	}

	private static long amountOfWorkNeededToTransferWine(int[] house) {
		List<Integer> sellers = new ArrayList<>();
		List<Integer> buyers = new ArrayList<>();
		
		for (int i = 0; i < house.length; i++) {
			if (house[i] > 0) {
				sellers.add(i);
			} else {
				buyers.add(i);
			}
		}
		
		int sellCounter = 0;
		int buyCounter = 0;
		
		long amountOfWorkNeedToBeDone = 0;
		
		while (sellCounter != sellers.size() &&
				buyCounter != buyers.size()) {
			int resolved = Math.min(house[sellers.get(sellCounter)], 0 - house[buyers.get(buyCounter)]);
			
   			house[sellers.get(sellCounter)] = house[sellers.get(sellCounter)] - resolved;
			house[buyers.get(buyCounter)] = house[buyers.get(buyCounter)] + resolved;
			
			amountOfWorkNeedToBeDone += amountOfWorkFromAToB(sellers.get(sellCounter), buyers.get(buyCounter), resolved);

			if (house[sellers.get(sellCounter)] == 0) {
				sellCounter++;
			}
			
			if (house[buyers.get(buyCounter)] == 0) {
				buyCounter++;
			}
		}
		
		return amountOfWorkNeedToBeDone;
	}
	
	private static int amountOfWorkFromAToB(int aLocation, int bLocation, int amount) {
		return amount * Math.abs(bLocation - aLocation);
	}
}
