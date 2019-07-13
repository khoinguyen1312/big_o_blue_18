package bellman;

public class BellmanFord {
	class Edge {
		public int source;
		public int target;
		public int weight;
	}
	
	private final int INF = Integer.MAX_VALUE;
	private Edge[] graph;
	private int numberOfNode;
	private int[] path;
	private int[] dist;
	
	public BellmanFord(Edge[] graph, int numberOfNode, int numberOfEdge) {
		this.graph = graph;
		this.numberOfNode = numberOfNode;
		this.path = new int[numberOfNode];
		this.dist = new int[numberOfNode];
	}
	
	public boolean bellmanFord() {
		for (int i = 0; i < numberOfNode - 1; i++) {
			for (int j = 0; j < graph.length; j++) {
				int from = graph[j].source;
				int to = graph[j].target;
				int weight = graph[j].weight;
				
				if (dist[from] != INF && dist[from] + weight < dist[to]) {
					dist[to] = dist[from] + weight;
					path[to] = from;
				}
			}
		}

		for (int j = 0; j < graph.length; j++) {
			int from = graph[j].source;
			int to = graph[j].target;
			int weight = graph[j].weight;
			
			if (dist[from] != INF && dist[from] + weight < dist[to]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
	}
}
