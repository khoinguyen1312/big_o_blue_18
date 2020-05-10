package heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Qheap {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
	
		int numberOfNumbers = argumentScanner.nextInt();
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for (int i = 0; i < numberOfNumbers; i++) {
			int nextInt = argumentScanner.nextInt();
			
			switch (nextInt) {
			case 1:
				queue.add(argumentScanner.nextInt());
				break;
			case 2:
				queue.remove(argumentScanner.nextInt());
				break;
			case 3:
				System.out.println(queue.peek());
				break;
			default:
				break;
			}
		}
		
		argumentScanner.close();
	}
}
