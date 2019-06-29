package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Prayatna {
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
    			int left = argumentScanner.nextInt();
    			int right = argumentScanner.nextInt();
    			
    			graph.get(left).add(right);
    			graph.get(right).add(left);
    		}
    		
    		int count = calculateNeccesaryPersonToMeetGroup(graph);
    		
    		System.out.println(count);
    		
    	}
    	
    	argumentScanner.close();
	}

	
	public static void test() {
		List<List<Integer>> graph = Arrays.asList(
				Collections.emptyList(),
				Collections.emptyList(),
				Collections.emptyList()
			);
		
		int count = calculateNeccesaryPersonToMeetGroup(graph);

		System.out.println(count);
	}


	private static int calculateNeccesaryPersonToMeetGroup(List<List<Integer>> graph) {
		int numberOfPeers = graph.size();
		
		boolean[] visited = new boolean[numberOfPeers];
		
		for (int i = 0; i < numberOfPeers; i++) {
			visited[i] = false;
		}
		
		int count = 0;
		
		while (!isAllVisitted(visited)) {
			count++;
			int notVisited = mostNearestNotVisited(visited);
			visitedDfs(notVisited, graph, visited);
		}
		return count;
	}
	
	public static int mostNearestNotVisited(boolean[] visited) {
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean isAllVisitted(boolean[] visited) {
		for (boolean visit : visited) {
			if (!visit) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean[] visitedDfs(int startingPoint, List<List<Integer>> graph, boolean visited[]) {
		int numberOfNode = graph.size();
		
		int[] path = new int[numberOfNode];
		
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
		
		return visited;
	}
}
