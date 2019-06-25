package stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThrowingCardsAway {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int nextArgument = argumentScanner.nextInt();
		
		while (nextArgument != 0) {
			int number = nextArgument;
		
			List<Integer> numbers = IntStream.range(1, number + 1).boxed().collect(Collectors.toList());
			
			printRemainingCard(numbers);
			
			nextArgument = argumentScanner.nextInt();
		} 
		
		argumentScanner.close();
	}
	
	public static void printRemainingCard(List<Integer> cards) {
		Queue<Integer> queueCards = new LinkedList<Integer>(cards);
		
		List<String> removeds = new ArrayList<>();
		
		while (queueCards.size() != 1) {
			Integer removed = queueCards.remove();
			removeds.add(removed.toString());
			
			Integer top = queueCards.remove();
			queueCards.add(top);
		}
		
		String discardedCard = String.join(", ", removeds);
		
		System.out.println("Discarded cards: " + discardedCard);
		
		System.out.println("Remaining card: " + queueCards.element());
	}
}
