package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ShortestReach {
	public static void main(String[] args) {
		List<List<Integer>> graph = Arrays.asList(
				Arrays.asList(1, 2),
				Arrays.asList(0, 3),
				Arrays.asList(0),
				Arrays.asList(1)
			);
		bfs(0, graph);
		bfs(0, graph);
		bfs(0, graph);
	}
	
	public static int[] bfs(int startPoint, List<List<Integer>> graph) {
		//optimize by calculate distance every time we reach a new point
		
		int numberOfNode = graph.size();
		
		int[] path = new int[numberOfNode];
		boolean[] visited = new boolean[numberOfNode];
		
		for (int i = 0; i < numberOfNode; i++) {
			path[i] = -1;
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
