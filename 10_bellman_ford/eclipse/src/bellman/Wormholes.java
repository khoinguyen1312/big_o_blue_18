package bellman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bellman.BellmanFord.Edge;

public class Wormholes {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int numberOfProblem = argumentScanner.nextInt();
    	
    	for (int i = 0; i < numberOfProblem; i++) {
    		int numberOfNode = argumentScanner.nextInt();
    		int numberOfEdge = argumentScanner.nextInt();
    		
    		List<Edge> edges = new ArrayList<>();
    		
    		for (int j = 0; j < numberOfEdge; j++) {
    			int source = argumentScanner.nextInt();
    			int target = argumentScanner.nextInt();
    			int weight = argumentScanner.nextInt();
    			edges.add(Edge.createInstance(source, target, weight));
    		}
    		
    		BellmanFord solution = new BellmanFord(edges, numberOfNode);
    		
    		if (solution.bellmanFord()) {
    			System.out.println("not possible");
    		} else {
    			System.out.println("possible");
    		}
    	}
    	
    	argumentScanner.close();
	}
}
