package binarysearchtree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IsenbaevNumber {
	public static void main(String[] args) {
		printIsenbaevNumber(Arrays.asList(
				Arrays.asList("Isenbaev", "Oparin", "Toropov"),
				Arrays.asList("Ayzenshteyn", "Oparin", "Samsonov"),
				Arrays.asList("Ayzenshteyn", "Chevdar", "Samsonov"),
				Arrays.asList("Fominykh", "Isenbaev", "Oparin"),
				Arrays.asList("Dublennykh", "Fominykh", "Ivankov"),
				Arrays.asList("Burmistrov", "Dublennykh", "Kurpilyanskiy"),
				Arrays.asList("Cormen", "Leiserson", "Rivest")
			));
		
	}
	
	public static void printIsenbaevNumber(List<List<String>> teams) {
		Set<String> allPartipant = new HashSet<>();
		
		for (List<String> team : teams) {
			for (String name : team) {
				allPartipant.add(name);
			}
		}
		
		Map<String, Set<String>> relationship = new HashMap<>();

		for (String name : allPartipant) {
			relationship.put(name, new HashSet<>());
		}
		
		for (List<String> team : teams) {
			relationship.get(team.get(0)).add(team.get(1));
			relationship.get(team.get(0)).add(team.get(2));

			relationship.get(team.get(1)).add(team.get(0));
			relationship.get(team.get(1)).add(team.get(2));

			relationship.get(team.get(2)).add(team.get(0));
			relationship.get(team.get(2)).add(team.get(1));
		}
		
		Map<String, Integer> result = new HashMap<>();
		calculate(result, relationship, "Isenbaev", 0);
		
		System.out.println(result);
	}
	
	public static void calculate(Map<String, Integer> result, Map<String, Set<String>> relationship, String beingCheck, int counter) {
		if (result.containsKey(beingCheck)) {
			return;
		}
		
		result.put(beingCheck, counter);
		
		for (String friend : relationship.get(beingCheck)) {
			calculate(result, relationship, friend, counter + 1);
		}
	}
}
