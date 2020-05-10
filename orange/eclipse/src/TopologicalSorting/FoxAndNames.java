package TopologicalSorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FoxAndNames {
	/*
	 * 
	 * Input: 
	 * 3
	 * rivest
	 * shamir
	 * adleman
	 * 
	 * Output:
	 *  bcdefghijklmnopqrsatuvwxyz
	 *  
	 * Input
	 *  10
		petr
		egor
		endagorion
		feferivan
		ilovetanyaromanova
		kostka
		dmitriyh
		maratsnowbear
		bredorjaguarturnik
		cgyforever
		
     * Output:
     * aghjlnopefikdmbcqrstuvwxyz
	 */
	
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
		int numberOfTextLine = argumentScanner.nextInt();
		List<String> texts = new ArrayList<>();
		
		for (int i = 0; i < numberOfTextLine; i++) {
			texts.add(argumentScanner.next());
		}
		
		argumentScanner.close();
		
		Map<Character, List<Character>> graph = new HashMap<>();
		for (char i = 'a'; i <= 'z'; i++) {
			graph.put(i, new ArrayList<>());
		}

		for (int textIndex = 1; textIndex < texts.size(); textIndex++) {
			char[] upperText = texts.get(textIndex - 1).toCharArray();
			char[] belowText = texts.get(textIndex).toCharArray();
			
			int minLength = Math.min(upperText.length, belowText.length);
			
			boolean isFoundConnection = false;
			
			for (int textCharIndex = 0; textCharIndex < minLength; textCharIndex ++) {
				if (upperText[textCharIndex] != belowText[textCharIndex]) {
					graph.get(upperText[textCharIndex]).add(belowText[textCharIndex]);
					isFoundConnection = true;
					break;
				}
			}
			
			if (!isFoundConnection && belowText.length < upperText.length) {
				System.out.println("Impossible");
				System.exit(0);
			}
		}
		
		List<Character> topologicalSorted = kahn(graph);
		
		if (topologicalSorted == null) {
			System.out.println("Impossible");
		} else {
			System.out.println(
					topologicalSorted.stream().map(String::valueOf).collect(Collectors.joining())
					);
		}
	}
	
	public static List<Character> kahn(Map<Character, List<Character>> graph) {
		Map<Character, Integer> dependenciesCount = new HashMap<>();
		
		for (Character c : graph.keySet()) {
			dependenciesCount.put(c, 0);
		}

		for (Character c : graph.keySet()) {
			for (Character belowChar : graph.get(c)) {
				dependenciesCount.put(belowChar, dependenciesCount.get(belowChar) + 1);
			}
		}
		
		List<Character> result = new ArrayList<>();
		Queue<Character> queue = new PriorityQueue<>();
		
		for (Character c : graph.keySet()) {
			if (dependenciesCount.get(c) == 0) {
				queue.add(c);
			}
		}
		
		while (!queue.isEmpty()) {
			Character nextCharacter = queue.poll();
			
			result.add(nextCharacter);
			for (Character belowCharacter : graph.get(nextCharacter)) {
				dependenciesCount.put(belowCharacter, dependenciesCount.get(belowCharacter) - 1);
				
				if (dependenciesCount.get(belowCharacter) == 0) {
					queue.add(belowCharacter);
				}
			}
		}
		
		if (result.size() != graph.size()) {
			return null;
		}
		
		return result;
	}
}
