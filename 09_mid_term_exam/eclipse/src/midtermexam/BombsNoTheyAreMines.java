package midtermexam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;

public class BombsNoTheyAreMines {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int numberOfRows = argumentScanner.nextInt();
    	int numberOfColumns = argumentScanner.nextInt();
		
		while (true) {
	    	int numberOfRowsHaveMine = argumentScanner.nextInt();
	    	
	    	char[][] matrix = new char[numberOfRows][numberOfColumns];
	    	
	    	for (int i = 0; i < numberOfRows; i++) {
	    		for (int j = 0; j < numberOfColumns; j++) {
	    			matrix[i][j] = '.';
	    		}
	    	}
	    	
	    	for (int i = 0; i < numberOfRowsHaveMine; i++) {
	    		int rowIndex = argumentScanner.nextInt();
	    		int numberOfRowBomb = argumentScanner.nextInt();
	    		
	    		char[] row = matrix[rowIndex];
	    		
	    		for (int j = 0; j < numberOfRowBomb; j++) {
	    			int bombColumn = argumentScanner.nextInt();
	    			row[bombColumn] = '#';
	    		}
	    	}
	    	
	    	int startingLocationRow = argumentScanner.nextInt();
	    	int startingLocationCol = argumentScanner.nextInt();
	    	
	    	int destinationRow = argumentScanner.nextInt();
	    	int destinationCol = argumentScanner.nextInt();
	    	
	    	
	    	int startPoint = fromMatrixPositionToListPosition(startingLocationRow, startingLocationCol, numberOfColumns);
	    	int destination = fromMatrixPositionToListPosition(destinationRow, destinationCol, numberOfColumns);
			
			
	    	List<List<Integer>> graph = FromMatrixToGraph.createInstance().fromLandMatrixToGraph(matrix);
			
			int[] path = BFS.bfs(startPoint, graph);
			
			List<Integer> direction = BFS.buildDirection(startPoint, destination, path);
			
			System.out.println(direction.size() - 1);
	    	
			numberOfRows = argumentScanner.nextInt();
			numberOfColumns = argumentScanner.nextInt();
			
			if (numberOfRows == 0 && numberOfColumns == 0) {
				break;
			}
		}
    	
    	argumentScanner.close();
	}
	
	public static int fromMatrixPositionToListPosition(int row, int col, int width) {
		return row * width + col;
	}
}

class BFS {
	public static int[] bfs(int startPoint, List<List<Integer>> graph) {
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

	public static List<Integer> buildDirection(int startPoint, int endPoint, int[] path) {
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

class FromMatrixToGraph {
	
	private FromMatrixToGraph() {
		
	}
	
	public static FromMatrixToGraph createInstance() {
		return new FromMatrixToGraph();
	}
	
	public List<List<Integer>> fromLandMatrixToGraph(char[][] landMatrix) {
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
		
		return graph;
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