package bellman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import bellman.BellmanFordExtendedTraffic.Edge;

public class ExtendedTraffic {
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	int numberOfProblem = argumentScanner.nextInt();
    	
    	for (int i = 0; i < numberOfProblem; i++) {
    		int numberOfNode = argumentScanner.nextInt();
    		
    		int[] weights = new int[numberOfNode];
    		for (int j = 0; j < numberOfNode; j++) {
    			weights[j] = argumentScanner.nextInt();
    		}
    		
    		int numberOfEdge = argumentScanner.nextInt();
    		
    		List<Edge> edges = new ArrayList<>();
    		
    		for (int j = 0; j < numberOfEdge; j++) {
    			int source = argumentScanner.nextInt() - 1;
    			int target = argumentScanner.nextInt() - 1;
    			int weight = cube(weights[source], weights[target]);
    			edges.add(Edge.createInstance(source, target, weight));
    		}
    		
    		BellmanFordExtendedTraffic solution = new BellmanFordExtendedTraffic(edges, numberOfNode);
    		
    		solution.bellmanFordExtendedTraffic(0);

    		int numberOfQuerry = argumentScanner.nextInt();
    		
    		int[] querries = new int[numberOfQuerry];
    		
    		for (int j = 0; j < numberOfQuerry; j++) {
    			querries[j] = argumentScanner.nextInt() - 1;
    		}
    		
    		System.out.println("Case " + (i + 1) + ":");
    		
    		for (int querry : querries) {
    			if (solution.dist[querry] == BellmanFordExtendedTraffic.INF || solution.dist[querry] < 3) {
    				System.out.println("?");
    			} else {
        			System.out.println(solution.dist[querry]);
    			}
    		}
    		
    	}
    	
    	argumentScanner.close();
	}
	
	public static void test() {
		int[] weights = new int[] {6, 7, 8, 9, 10};
		BellmanFordExtendedTraffic solution = new BellmanFordExtendedTraffic(Arrays.asList(
				Edge.createInstance(0, 1, cube(weights[0], weights[1])),
				Edge.createInstance(1, 2, cube(weights[1], weights[2])),
				Edge.createInstance(2, 3, cube(weights[2], weights[3])),
				Edge.createInstance(0, 4, cube(weights[0], weights[4])),
				Edge.createInstance(4, 3, cube(weights[4], weights[3])),
				Edge.createInstance(3, 4, cube(weights[3], weights[4]))),
				5);
		
		solution.bellmanFordExtendedTraffic(0);
		
		System.out.println(solution.dist[3]);
		System.out.println(solution.dist[4]);
		
		System.out.println("-------------");

		weights = new int[] {10, 10};
		solution = new BellmanFordExtendedTraffic(Arrays.asList(
				Edge.createInstance(0, 1, cube(weights[0], weights[1]))),
				2);
		
		solution.bellmanFordExtendedTraffic(0);
		
		System.out.println(solution.dist[1]);
	}
	
	public static int cube(int source, int target) {
		return (target - source) * (target - source) * (target - source);
	}
}

class BellmanFordExtendedTraffic {
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
	
	public final static int INF = Integer.MAX_VALUE;
	public List<Edge> graph;
	public int numberOfNode;
	public int[] path;
	public int[] dist;
	
	public BellmanFordExtendedTraffic(List<Edge> graph, int numberOfNode) {
		this.graph = graph;
		this.numberOfNode = numberOfNode;
		this.path = new int[numberOfNode];
		this.dist = new int[numberOfNode];
		for (int i = 0; i < numberOfNode; i++) {
			this.path[i] = -1;
			this.dist[i] = INF;
		}
	}
	
	public boolean bellmanFordExtendedTraffic(int startingPoint) {
		this.dist[startingPoint] = 0;
		
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
