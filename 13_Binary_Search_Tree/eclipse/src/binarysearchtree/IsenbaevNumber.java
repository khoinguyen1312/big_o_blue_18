package binarysearchtree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

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

		for (String name :  allPartipant) {
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
		result = bfs("Isenbaev", relationship);
		
		for (Entry<String, Integer> entry : result.entrySet()) {
			if (entry.getValue() == null) {
				System.out.println(entry.getKey() + " undefined");
			} else {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
	}
	
	public static Map<String, Integer> bfs(String startPoint, Map<String, Set<String>> graph) {
		Map<String, String> path = new HashMap<>();
		Map<String, Integer> distance = new TreeMap<>();
		Set<String> visited = new HashSet<String>();
		
		for (Entry<String, Set<String>> entry : graph.entrySet()) {
			distance.put(entry.getKey(), null);
		}
		
		
		
		Queue<String> queue = new LinkedList<>();
		queue.add(startPoint);
		
		path.put(startPoint, "");
		distance.put(startPoint, 0);
		visited.add(startPoint);
		
		while (!queue.isEmpty()) {
			String currentPoint = queue.remove();
			
			Set<String> nextPoints = graph.get(currentPoint);
			
			for (String nextPoint : nextPoints) {				
				if (!visited.contains(nextPoint)) {
					visited.add(nextPoint);
					queue.add(nextPoint);
					path.put(nextPoint, currentPoint);
					distance.put(nextPoint, distance.get(currentPoint) + 1);
				}
			}
		}
		
		
		return distance;
	}
}
