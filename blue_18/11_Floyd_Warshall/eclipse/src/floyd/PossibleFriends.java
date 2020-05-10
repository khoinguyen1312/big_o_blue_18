package floyd;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PossibleFriends {
	public static final int I = FloydWarshallPossipleFriends.INF;
	
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int numberOfProblems = argumentScanner.nextInt();
    	
    	for (int i = 0; i < numberOfProblems; i++) {
    		String firstLine = argumentScanner.next();
    		
    		int numberOfNode = firstLine.length();
    		
    		char[][] grapth = new char[numberOfNode][numberOfNode];
    		
    		grapth[0] = firstLine.toCharArray();
    		for (int j = 1; j < numberOfNode; j++) {
    			grapth[j] = argumentScanner.next().toCharArray();
    		}
    		
    		int[][] inputGraph = new int[numberOfNode][numberOfNode];
    		
    		for (int j = 0; j < numberOfNode; j++) {
    			for (int z = 0; z < numberOfNode; z++) {
    				if (j == z) {
    					inputGraph[j][z] = 0;
    				} else {
    					if (grapth[j][z] == 'Y') {
    						inputGraph[j][z] = 1;
    					} else {
    						inputGraph[j][z] = FloydWarshallPossipleFriends.INF;
    					}
    				}
    			}
    		}
    		
    		FloydWarshallPossipleFriends solution = new FloydWarshallPossipleFriends(inputGraph);
    		solution.floydWarshall();
    		int[] countTwo = new int[numberOfNode];
    		
    		for (int j = 0; j < numberOfNode; j++) {
    			countTwo[j] = (int) IntStream.of(solution.dist[j]).filter(step -> step == 2).count();
    		}
    		
    		int maxIndex = 0;
    		
    		for (int j = 1; j < numberOfNode; j++) {
    			if (countTwo[maxIndex] < countTwo[j]) {
    				maxIndex = j;
    			}
    		}
    		
    		System.out.println(maxIndex + " " + countTwo[maxIndex]);
    	}
    	
    	argumentScanner.close();
	}
	
	public static void test() {
//		FloydWarshallPossipleFriends solution = new FloydWarshallPossipleFriends(
//				Arrays.asList(
//						Arrays.asList(0, 1, 1, 1),
//						Arrays.asList(1, 0, I, 1),
//						Arrays.asList(1, I, 0, I),
//						Arrays.asList(1, 1, I, 0)
//						)
//				);
//		
//		solution.floydWarshall();
//		
//		for (int i = 0; i < 4; i++) {
//			System.out.println(IntStream.of(solution.dist[i]).mapToObj(Integer::valueOf).collect(Collectors.toList()));
//		}
	}
}

class FloydWarshallPossipleFriends {
	public static final int INF = Short.MAX_VALUE;
	public int[][] path;
	public int[][] dist;
	public int[][] grapth;
	
	public FloydWarshallPossipleFriends(int[][] grapth) {
		int numberOfNode = grapth.length;
		
		this.path = new int [numberOfNode][numberOfNode];
		this.dist = new int [numberOfNode][numberOfNode];
		this.grapth = new int [numberOfNode][numberOfNode];
		
		for (int i = 0; i < numberOfNode; i++) {
			for (int j = 0; j < numberOfNode; j++) {
				this.grapth[i][j] = grapth[i][j];
				this.dist[i][j] = grapth[i][j];
				
				if (grapth[i][j] != INF && i != j) {
					path[i][j] = i;
				} else {
					path[i][j] = - 1;
				}
			}
		}
	}
	
	public boolean floydWarshall() {
		int numberOfNode = this.grapth.length;
		
		for (int  k = 0; k < numberOfNode; k++) {
			for (int i = 0; i < numberOfNode; i++) {
				for (int j = 0; j < numberOfNode; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						path[i][j] = path[k][j];
					}
				}
			}
		}
		
		for (int i = 0; i < numberOfNode; i++) {
			if (dist[i][i] < 0) {
				return false;
			}
		}
		
		return true;
	}
}
