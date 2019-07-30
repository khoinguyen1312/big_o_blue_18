package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class AllIzzWell {
	public static void main(String[] args) {
		
	}
	
	public static void test() {
		
	}


	private static int calculateNeccesaryPersonToMeetGroup(List<List<Integer>> graph) {
		int numberOfPeers = graph.size();
		
		boolean[] visited = new boolean[numberOfPeers];
		int[] path = new int[numberOfPeers];
		
		for (int i = 0; i < numberOfPeers; i++) {
			visited[i] = false;
			path[i] = -1;
		}
		
		int count = 0;

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				count++;
				visitedDfs(i, graph, visited, path);
			}
		}
		
		return count;
	}
	
	public static boolean[] visitedDfs(int startingPoint, List<List<Integer>> graph, boolean visited[], int[] path) {
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

class FromMatrixToGraphResult {
	private int startingPoint;
	private List<List<Integer>> graph;

	public int getStartingPoint() {
		return startingPoint;
	}

	public List<List<Integer>> getGraph() {
		return graph;
	}

	FromMatrixToGraphResult(int startingPoint, List<List<Integer>> graph) {
		this.startingPoint = startingPoint;
		this.graph = graph;
	}
}

class FromMatrixToGraph {
	
	private FromMatrixToGraph() {
		
	}
	
	public static FromMatrixToGraph createInstance() {
		return new FromMatrixToGraph();
	}
	
	private int startingPoint = -1;
	
	public FromMatrixToGraphResult fromLandMatrixToGraph(char[][] landMatrix) {
		int height = landMatrix.length;
		int width = landMatrix[0].length;
		
		int numberOfPoint = width * height;
		
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < numberOfPoint; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (landMatrix[row][col] != '#') {
					
					int pointPosition = fromMatrixPositionToListPosition(row, col, width); 	
					
					Optional<Point> leftPoint= Point.withPoint(row, col).leftPoint();
					addPointToGraph(landMatrix, width, graph, pointPosition, leftPoint);
					
					Optional<Point> rightPoint= Point.withPoint(row, col).rightPoint(width);
					addPointToGraph(landMatrix, width, graph, pointPosition, rightPoint);
					
					Optional<Point> topPoint= Point.withPoint(row, col).topPoint();
					addPointToGraph(landMatrix, width, graph, pointPosition, topPoint);
					
					Optional<Point> bottomPoint= Point.withPoint(row, col).bottomPoint(height);
					addPointToGraph(landMatrix, width, graph, pointPosition, bottomPoint);
					
				}
			}
		}
		
		return new FromMatrixToGraphResult(startingPoint, graph);
	}


	private void addPointToGraph(char[][] landMatrix,
			int width,
			List<List<Integer>> graph,
			int pointPosition,
			Optional<Point> point) {
		if (point.isPresent()) {
			Point foundConnectedPoint = point.get();
			char foundConnectedPointCharacter = landMatrix[foundConnectedPoint.getRow()][foundConnectedPoint.getCol()];
			
			if (foundConnectedPointCharacter == '#') {
				return;
			}
			
			if (foundConnectedPointCharacter == '@') {
				startingPoint = fromMatrixPositionToListPosition(foundConnectedPoint.getRow(), foundConnectedPoint.getCol(), width);
			}

			int foundConnectedPointPosition = fromMatrixPositionToListPosition(foundConnectedPoint.getRow(), foundConnectedPoint.getCol(), width);
			graph.get(pointPosition).add(foundConnectedPointPosition);
		}
	}
	
	public int fromMatrixPositionToListPosition(int row, int col, int width) {
		return row * width + col;
	}
}


class Point {
	private int row;
	private int col;

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	private Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public static Point withPoint(int row, int col) {
		return new Point(row, col);
	}
	
	public Optional<Point> leftPoint() {
		if (col == 0) {
			return Optional.empty();
		}
		return Optional.of(new Point(row, col - 1));
	}

	public Optional<Point> rightPoint(int width) {
		if (col == width - 1) {
			return Optional.empty();
		}
		return Optional.of(new Point(row, col + 1));
	}

	public Optional<Point> topPoint() {
		if (row == 0) {
			return Optional.empty();
		}
		return Optional.of(new Point(row - 1, col));
	}

	public Optional<Point> bottomPoint(int height) {
		if (row == height - 1) {
			return Optional.empty();
		}
		return Optional.of(new Point(row + 1, col));
	}
	
	// add 4 function to get top-left, top-right, bot-left, bot-right
}
