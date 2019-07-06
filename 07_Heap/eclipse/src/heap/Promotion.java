package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Promotion {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
	
		int numberOfDays = argumentScanner.nextInt();
		
		List<List<Integer>> days = new ArrayList<>();
		
		for (int i = 0; i < numberOfDays; i++) {
			int numberOfThisDay = argumentScanner.nextInt();

			List<Integer> day = new ArrayList<>();
			
			for (int j = 0; j < numberOfThisDay; j++) {
				day.add(argumentScanner.nextInt());
			}
			
			days.add(day);
		}
		
		argumentScanner.close();
		
		int cost = calculateCostOfPromotion(days);
		
		System.out.println(cost);
	}
	
	public static void test() {
		calculateCostOfPromotion(Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(1, 1),
				Arrays.asList(10, 5, 5, 1),
				Collections.emptyList(),
				Arrays.asList(2)
			));
		
	}
	
	public static int calculateCostOfPromotion(List<List<Integer>> days) {
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b.compareTo(a));
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		
		int cost = 0;
		
		for (List<Integer> day : days) {
			for (Integer prize : day) {
				maxQueue.add(prize);
				minQueue.add(prize);
			}
			
			Integer max = maxQueue.poll();
			Integer min = minQueue.poll();
			
			maxQueue.remove(min);
			minQueue.remove(max);
			
			cost += max - min;

			
//			System.out.println("Max, Min: " + max + ", " + min + "| max - min = " +  (max - min));
		}
		
//		System.out.println(cost);
		
		return cost;
	}
}
