package bellman;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {
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
	
	public BellmanFord(List<Edge> graph, int numberOfNode) {
		this.graph = graph;
		this.numberOfNode = numberOfNode;
		this.path = new int[numberOfNode];
		this.dist = new int[numberOfNode];
	}
	
	public boolean bellmanFord() {
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
	
	public static void main(String[] args) {
		BellmanFord solution = new BellmanFord(
				Arrays.asList(
					new Edge(0, 1, 10),
					new Edge(1, 2, 20),
					new Edge(2, 3, 30),
					new Edge(3, 0, -60)
					),
				4);
		System.out.println(solution.bellmanFord());
		

		solution = new BellmanFord(
				Arrays.asList(
					new Edge(0, 1, 1000),
					new Edge(1, 2, 15),
					new Edge(2, 1, -42)
					),
				3);

		System.out.println(solution.bellmanFord());
	}
}
