package bellman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bellman.BellmanFord.Edge;

public class Xyzzy {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int input = argumentScanner.nextInt();
    	
    	while (input != -1) {
	    	int numberOfNode = input;
	    	
	    	int startNode = -1;
	    	int endNode = -1;

    		List<Edge> edges = new ArrayList<>();
    		
	    	for (int i = 0; i < numberOfNode; i++) {
	    		int weight = argumentScanner.nextInt();
	    		if (weight == 0) {
	    			if (startNode == -1) {
	    				startNode = i;
	    			} else {
	    				endNode = i;
	    			}
	    		}
	    		
	    		int numberOfEdge = argumentScanner.nextInt();
	    		
	    		for (int j = 0; j < numberOfEdge; j++) {
	    			int target = argumentScanner.nextInt();
	    			
	    			edges.add(Edge.createInstance(i, target, - weight));
	    		}
	    	}
    		
    		BellmanFord solutionStartNode = new BellmanFord(edges, numberOfNode);
    		BellmanFord solutionEndtNode = new BellmanFord(edges, numberOfNode);

//	    	if (solutionStartNode.dist[endNode] != BellmanFord.)
    		
    		System.out.println(solutionStartNode.bellmanFord(startNode));
    		System.out.println(solutionEndtNode.bellmanFord(endNode));
	    	
	    	
	    	input = argumentScanner.nextInt();
    	}
		
    	argumentScanner.close();
	}
	
	/*-> Change Bellman Ford to find maximum positive path
	 * 
	 * 
	 * 
	 * if dist[u] != -INF && dist[u] + w > dist[v] & hashPath(u, n)
	 * 		return true;
	 * 
	 * if dist[v] > 0
	 * 		return true;
	 * 
	 * return false;
	 */
}
