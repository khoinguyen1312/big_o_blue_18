package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TheLastShot {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
	
		int numberOfNode = argumentScanner.nextInt();
		int numberOfEdge = argumentScanner.nextInt();
		
		List<List<Integer>> graph = new ArrayList<>(numberOfNode);
		for (int j = 0; j < numberOfNode; j++) {
			graph.add(new ArrayList<>());
		}
		
		for (int j = 0; j < numberOfEdge; j++) {
			int left = argumentScanner.nextInt() - 1;
			int right = argumentScanner.nextInt() - 1;
			
			graph.get(left).add(right);
			graph.get(right).add(left);
		}
		
		long count = calculateMaximumEffect(graph);
		
		System.out.println(count);
		
    	
    	argumentScanner.close();
	}
	
	public static void test() {
		List<List<Integer>> graph = Arrays.asList(
				Collections.emptyList(),
				Arrays.asList(2, 3),
				Arrays.asList(1, 3),
				Arrays.asList(1, 2),
				Collections.emptyList()
			);
		
		long result = calculateMaximumEffect(graph);
		
		System.out.println(result);
	}


	private static long calculateMaximumEffect(List<List<Integer>> graph) {
		int numberOfPeers = graph.size();
		
		Boolean[] visited = new Boolean[numberOfPeers];
		int[] path = new int[numberOfPeers];
		
		for (int i = 0; i < numberOfPeers; i++) {
			visited[i] = false;
			path[i] = -1;
		}
		
		long maximumEffect = 0;

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				int thisGroupEffect = visitedDfs(i, graph, visited, path);
				
				if (thisGroupEffect > maximumEffect) {
					maximumEffect = thisGroupEffect;
				}
			}
		}
		
		return maximumEffect;
	}
	
	public static int visitedDfs(int startingPoint, List<List<Integer>> graph, Boolean visited[], int[] path) {
		Stack<Integer> stack = new Stack<>();
		stack.add(startingPoint);
		visited[startingPoint] = true;
		
		int count = 1;
		
		while (!stack.isEmpty()) {
			Integer currentPoint = stack.pop();
			
			List<Integer> nextPoints = graph.get(currentPoint);
			
			for (int i = 0; i < nextPoints.size(); i++) {
				int nextPoint = nextPoints.get(i);
				
				if (!visited[nextPoint]) {
					visited[nextPoint] = true;
					stack.add(nextPoint);
					path[nextPoint] = currentPoint;
					
					count++;
				}
			}
		}
		
		return count;
	}
}
