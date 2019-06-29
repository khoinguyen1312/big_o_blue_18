package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Dfs {
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		List<List<Integer>> graph = Arrays.asList(
				Arrays.asList(1, 3),
				Arrays.asList(0, 2, 3, 5),
				Arrays.asList(1, 5),
				Arrays.asList(0, 1, 4, 5),
				Arrays.asList(3),
				Arrays.asList(1, 2, 3)
			);
		int[] path = dfs(0, graph);
		
		System.out.println(buildDirection(0, 5, path));
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
