package stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThatIsYourQueue {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int nextArgument = argumentScanner.nextInt();
    	
    	int problemCounter = 1;
    	
    	while (nextArgument != 0) {
    		System.out.println("Case " + problemCounter + ":");
    		problemCounter++;
    		
	    	int numberOfPatients = nextArgument;
	    	int sizeOfOrder = argumentScanner.nextInt();
	    	
	    	List<Character> orders = new ArrayList<>();
	    	for (int i = 0; i < sizeOfOrder; i++) {
	    		Character order = argumentScanner.next().toCharArray()[0];
	    		orders.add(order);
	    		
	    		if (order == 'E') {
	    			sizeOfOrder++;
	    		}
	    	}
	    	
	    	printOrder(numberOfPatients, orders);
	    	
	    	nextArgument = argumentScanner.nextInt();
    	} 
    	
    	argumentScanner.close();
	}
	
	public static void printOrder(int numberOfPatient, List<Character> orders) {
		Queue<Character> ordersQueue = new LinkedList<>(orders);
		
		List<Integer> patients = IntStream.range(1, numberOfPatient + 1).boxed().collect(Collectors.toList());
		
		Queue<Integer> patientsQueue = new LinkedList<>(patients);
		
		/*
		 * As about memory, 
		 * push min(numberOfPatient, order.size())
		 */
		
		while (!ordersQueue.isEmpty()) {
			Character order = ordersQueue.remove();
			
			if (order == 'N') {
				Integer patient = patientsQueue.remove();
				
				System.out.println(patient);
				
				patientsQueue.add(patient);
			} else if (order == 'E') {
				Integer emergencyCase = Integer.parseInt(ordersQueue.remove().toString());
				
				patientsQueue.add(emergencyCase);
				
				while (patientsQueue.peek() != emergencyCase) {
					Integer nextPatient = patientsQueue.remove();
					patientsQueue.add(nextPatient);
				}
				
				patientsQueue.remove();

				while (patientsQueue.peek() != emergencyCase) {
					Integer nextPatient = patientsQueue.remove();
					patientsQueue.add(nextPatient);
				}
			}
		}
	}
}
