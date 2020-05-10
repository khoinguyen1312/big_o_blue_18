package bellman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bellman.BellmanFordWormholes.Edge;

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
    		
    		BellmanFordWormholes solution = new BellmanFordWormholes(edges, numberOfNode);
    		
    		if (solution.bellmanFordWormholes()) {
    			System.out.println("not possible");
    		} else {
    			System.out.println("possible");
    		}
    	}
    	
    	argumentScanner.close();
	}
}

class BellmanFordWormholes {
	static class Edge {
		public int source;
		public int target;
		public int weight;
		
		private Edge(int source, int target, int weight) {
			this.source = source;
			this.target = target;
			this.weight = weight;
		}
		
		public static Edge createInstance(int source, int target, int weight) {
			return new Edge(source, target, weight);
		}
	}
	
	private final int INF = Integer.MAX_VALUE;
	private List<Edge> graph;
	private int numberOfNode;
	private int[] path;
	private int[] dist;
	
	public BellmanFordWormholes(List<Edge> graph, int numberOfNode) {
		this.graph = graph;
		this.numberOfNode = numberOfNode;
		this.path = new int[numberOfNode];
		this.dist = new int[numberOfNode];
	}
	
	public boolean bellmanFordWormholes() {
		for (int i = 0; i < numberOfNode - 1; i++) {
			for (int j = 0; j < graph.size(); j++) {
				int from = graph.get(j).source;
				int to = graph.get(j).target;
				int weight = graph.get(j).weight;
				
				if (dist[from] != INF && dist[from] + weight < dist[to]) {
					dist[to] = dist[from] + weight;
					path[to] = from;
				}
			}
		}

		for (int j = 0; j < graph.size(); j++) {
			int from = graph.get(j).source;
			int to = graph.get(j).target;
			int weight = graph.get(j).weight;
			
			if (dist[from] != INF && dist[from] + weight < dist[to]) {
				return false;
			}
		}
		
		return true;
	}
}
