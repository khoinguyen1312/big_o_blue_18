package minimumspanningtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.LongStream;

public class FindMST {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int numberOfNode = argumentScanner.nextInt();
		int numberOfEdge = argumentScanner.nextInt();
		
		List<List<MSTNode>> graph = new ArrayList<>();
		
		for (int i = 0; i < numberOfNode; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < numberOfEdge; i++) {
			int leftNodeId = argumentScanner.nextInt() - 1;
			int rightNodeId = argumentScanner.nextInt() - 1;
			long lengthBetweenNodes = argumentScanner.nextLong();
			
			graph.get(leftNodeId).add(new MSTNode(rightNodeId, lengthBetweenNodes));
			graph.get(rightNodeId).add(new MSTNode(leftNodeId, lengthBetweenNodes));
		}
		
		argumentScanner.close();
		
		MST solution = new MST(graph);
		solution.prim(0);
		System.out.println(LongStream.of(solution.distance).sum());
	}
}

class MSTNode implements Comparable<MSTNode> {
	Integer id;
	Long dist;
	
	MSTNode(Integer id, Long dist) {
		this.id = id;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(MSTNode other) {
		return this.dist.compareTo(other.dist);
	}
}	

class MST {
	
	public MST(List<List<MSTNode>> graph) {
		this.graph = graph;
		int numberOfNode = graph.size();
		
		priorityQueue = new PriorityQueue<>();
		
		distance = new long[numberOfNode];
		path = new int[numberOfNode];
		visited = new boolean[numberOfNode];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(path, -1);
		Arrays.fill(visited, false);
	}
	
	public long[] distance;
	public int[] path;
	public boolean[] visited;
	public PriorityQueue<MSTNode> priorityQueue;
	public List<List<MSTNode>> graph;
	
	public void prim(int beginNodeIndex) {
		priorityQueue.add(new MSTNode(beginNodeIndex, 0l));
		distance[beginNodeIndex] = 0;
		
		while (!priorityQueue.isEmpty()) {
			MSTNode currentNode = priorityQueue.poll();
			
			visited[currentNode.id] = true;
			
			for (MSTNode neighbor : graph.get(currentNode.id)) {
				if (!visited[neighbor.id] && neighbor.dist < distance[neighbor.id]) {
					distance[neighbor.id] = neighbor.dist;
					priorityQueue.add(new MSTNode(neighbor.id,  neighbor.dist));
					path[neighbor.id] = currentNode.id;
				}
			}
		}
	}
	
	
}
