package TopologicalSorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Hierarchy {

	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
		int numberOfTasks = argumentScanner.nextInt();
		int numberOfLineInput = argumentScanner.nextInt();
		
		List<List<Integer>> graph = new ArrayList<>(numberOfTasks);
		for (int i = 0; i < numberOfTasks; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < numberOfLineInput; i++) {
			int numberOfWish = argumentScanner.nextInt();
			for (int j = 0; j < numberOfWish; j++) {
				graph.get(i).add(argumentScanner.nextInt() - 1);
			}
		}
		
		argumentScanner.close();
		
		List<Integer> topologicalSorted = kahn(graph);
		
		if (topologicalSorted == null) {
			System.out.println("Sandro fails.");
		} else {
			List<String> collect = topologicalSorted.stream().map(i -> Integer.toString(i + 1)).collect(Collectors.toList());
			System.out.println(String.join(" ", collect));
		}
		
		
	}
	
	public static List<Integer> kahn(List<List<Integer>> graph) {
		Map<Integer, PriorityQueue<Integer>> dependencies = new HashMap<>();
		
		for (int i = 0; i < graph.size(); i++) {
			dependencies.put(i, new PriorityQueue<>());
		}

		for (int i = 0; i < graph.size(); i++) {
			for (int j : graph.get(i)) {
				dependencies.get(j).add(i);
			}
		}
		
		
		List<Integer> result = new ArrayList<>();
		Queue<Integer> queue = new PriorityQueue<Integer>();
		
		for (int i = 0; i < graph.size(); i++) {
			if (dependencies.get(i).size() == 0) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			Integer nextNumber = queue.poll();
			
			result.add(nextNumber);
			for (int i : graph.get(nextNumber)) {
				Integer nextNode = dependencies.get(i).poll();
				if (nextNode == null) {
					queue.add(i);
				}
			}
		}
		
		if (result.size() != graph.size()) {
			return null;
		}
		
		return result;
	}
}
