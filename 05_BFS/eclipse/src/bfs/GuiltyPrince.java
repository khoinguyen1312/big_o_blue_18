package bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GuiltyPrince {
	public static void main(String[] args) {
		char[][] matrix = new char[][] {
			{'.', '.', '.', '.', '#', '.'},
			{'.', '.', '.', '.', '.', '#'},
			{'.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.'},
			{'#', '@', '.', '.', '.', '#'},
			{'.', '#', '.', '.', '#', '.'}
		};
		
		FromMatrixToGraphResult result = FromMatrixToGraph.createInstance().fromLandMatrixToGraph(matrix);
		
		int[] path = BFS.bfs(result.getStartingPoint(), result.getGraph());
		
		int foundLand = 1;
		
		for (int i = 0; i < path.length; i++) {
			if (path[i] != -1) {
				foundLand++;
			}
		}
		
		System.out.println(foundLand);
	}
	
	
	public static int numberOfLandPrinceCanReach(char[][] landMaxtrix) {
		
		return 0;
		
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
		
		for (int row = 0; row < landMatrix.length; row++) {
			for (int col = 0; col < landMatrix[row].length; col++) {
				if (landMatrix[row][col] != '#') {
					
					int pointPosition = fromMatrixPositionToListPosition(row, col, height); 	
					
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
}
