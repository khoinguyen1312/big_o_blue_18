package MidTerm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class OliverAndTheGame {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int numberOfNode = argumentScanner.nextInt();
		
		List<List<Integer>> graph = new ArrayList<>();
		
		for (int i = 0; i < numberOfNode; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < numberOfNode - 1; i++) {
			int left = argumentScanner.nextInt() - 1;
			int right = argumentScanner.nextInt() - 1;
			
			graph.get(left).add(right);
			graph.get(right).add(left);
		}

		int numberOfQueris = argumentScanner.nextInt();
		
		int[] path = dfs(0, graph);
		
		for (int i = 0; i < numberOfQueris; i++) {
			boolean isMoveIn = argumentScanner.nextInt() == 0;
			int X = argumentScanner.nextInt() - 1;
			int Y = argumentScanner.nextInt() - 1;
			
			boolean isFound = false;
			
			if (isMoveIn) {
				List<Integer> direction = buildDirection(0, Y, path);
				
				if (direction.contains(X)) {
					isFound = true;
				}
			} else {
				List<Integer> direction = buildDirection(Y, X, path);
				if (direction.contains(Y)) {
					isFound = true;
				}
			}
			
			if (isFound) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		argumentScanner.close();
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
			return Collections.emptyList();
		}
		
		int lookupPoint = endPoint;
		while (true) {
			if (lookupPoint == startPoint) {
				direction.add(lookupPoint);
				break;
			}
			
			direction.add(lookupPoint);

			if (path[lookupPoint] == -1) {
				return direction;
			}
			
			lookupPoint = path[lookupPoint];
		}
		
		return direction;
	}
}
