package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ShortestReach {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int numberOfProblem = argumentScanner.nextInt();
    	
    	for (int i = 0; i < numberOfProblem; i++) {
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
    		
    		int startingPoint = argumentScanner.nextInt() - 1;

    		printDistance(startingPoint, graph);
    	}
    	
    	argumentScanner.close();
	}

	private static void printDistance(int startingPoint, List<List<Integer>> graph) {
		int[] distances = distanceBfs(startingPoint, graph);
				
		List<String> output = new ArrayList<>();
		
		for (int i = 0; i < distances.length; i++) {
			if (i != startingPoint) {
				int distance = distances[i];
				if (distance == 0) {
					output.add(Integer.valueOf(-1).toString());
				} else {
					output.add(Integer.valueOf(distances[i] * 6).toString());
				}
			}
		}
		
		System.out.println(String.join(" ", output));
	}
	
	public static int[] distanceBfs(int startPoint, List<List<Integer>> graph) {
		int numberOfNode = graph.size();
		
		int[] path = new int[numberOfNode];
		int[] distance = new int[numberOfNode];
		boolean[] visited = new boolean[numberOfNode];
		
		for (int i = 0; i < numberOfNode; i++) {
			path[i] = -1;
			distance[i] = 0;
			visited[i] = false;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startPoint);
		visited[startPoint] = true;
		
		while (!queue.isEmpty()) {
			Integer currentPoint = queue.remove();
			
			List<Integer> nextPoints = graph.get(currentPoint);
			
			for (int i = 0; i < nextPoints.size(); i++) {
				int nextPoint = nextPoints.get(i);
				
				if (!visited[nextPoint]) {
					visited[nextPoint] = true;
					queue.add(nextPoint);
					path[nextPoint] = currentPoint;
					distance[nextPoint] = distance[currentPoint] + 1;
				}
			}
		}
		
		
		return distance;
	}
}
