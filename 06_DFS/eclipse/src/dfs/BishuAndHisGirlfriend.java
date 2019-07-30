package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BishuAndHisGirlfriend {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
		int numberOfCountries = argumentScanner.nextInt() + 1;
		int numberOfEdge = numberOfCountries - 1 - 1;
		
		List<List<Integer>> graph = new ArrayList<>(numberOfCountries);
		for (int j = 0; j < numberOfCountries; j++) {
			graph.add(new ArrayList<>());
		}
		
		for (int j = 0; j < numberOfEdge; j++) {
			int left = argumentScanner.nextInt() - 1;
			int right = argumentScanner.nextInt() - 1;
			
			graph.get(left).add(right);
			graph.get(right).add(left);
		}
		
		int numberOfPrinceses = argumentScanner.nextInt();
		List<Integer> princeses = new ArrayList<>();
		for (int i = 0; i < numberOfPrinceses; i++) {
			princeses.add(argumentScanner.nextInt() - 1);
		}
		
		
    	argumentScanner.close();
		
		int startingPoint = 0;
		
		int[] path = dfs(startingPoint, graph);
		
		int foundedQueen = -1;
		int distanceToFoundedQueen = numberOfCountries;

		for (Integer princes : princeses) {
			int distanceToPrinces = buildDirection(startingPoint, princes, path).size();
			if (distanceToPrinces < distanceToFoundedQueen) {
				foundedQueen = princes;
				distanceToFoundedQueen = distanceToPrinces;
			} else if (distanceToFoundedQueen == distanceToPrinces) {
				if (princes < foundedQueen) {
					foundedQueen = princes;
				}
			}
		}
		
		System.out.println(foundedQueen + 1);
	}
	
	public static void test() {
		List<List<Integer>> graph = Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(4, 5),
				Collections.emptyList(),
				Collections.emptyList(),
				Collections.emptyList(),
				Collections.emptyList()
			);
		int[] path = dfs(0, graph);
		
		System.out.println(buildDirection(0, 3, path));
		System.out.println(buildDirection(0, 4, path));
		System.out.println(buildDirection(0, 5, path));
		System.out.println(buildDirection(0, 2, path));
	}

	public static int[] dfs(int startingPoint, List<List<Integer>> graph) {
		int numberOfNode = graph.size();
		
		int[] path = new int[numberOfNode];
		boolean[] visited = new boolean[numberOfNode];
		
		for (int i = 0; i < numberOfNode; i++) {
			path[i] = -1;
			visited[i] = false;
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.add(startingPoint);
		visited[startingPoint] = true;
		
		while (!stack.isEmpty()) {
			Integer currentPoint = stack.pop();
			
			List<Integer> nextPoints = graph.get(currentPoint);
			
			for (int i = 0; i < nextPoints.size(); i++) {
				int nextPoint = nextPoints.get(i);
				
				if (!visited[nextPoint]) {
					visited[nextPoint] = true;
					stack.add(nextPoint);
					path[nextPoint] = currentPoint;
				}
			}
		}
		
		return path;
	}


	private static List<Integer> buildDirection(int startPoint, int endPoint, int[] path) {
		List<Integer> direction = new ArrayList<>();
		
		if (path[endPoint] == -1) {
			return null;
		}
		
		int lookupPoint = endPoint;
		while (true) {
			direction.add(lookupPoint);
			
			lookupPoint = path[lookupPoint];
			
			if (lookupPoint == startPoint) {
				direction.add(lookupPoint);
				break;
			}
		}
		
		return direction;
	}
}
