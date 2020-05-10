package minimumspanningtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.LongStream;

public class CobbledStreets {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int numberOfProblem = argumentScanner.nextInt();
		
		for (int problem = 0; problem < numberOfProblem; problem++) {
			int priceToPaveOneFurlongStreet = argumentScanner.nextInt();
			int numberOfBuilding = argumentScanner.nextInt();
			int numberOfStreet = argumentScanner.nextInt();

			List<List<CobNode>> graph = new ArrayList<>();
			
			for (int i = 0; i < numberOfBuilding; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < numberOfStreet; i++) {
				int leftNodeId = argumentScanner.nextInt() - 1;
				int rightNodeId = argumentScanner.nextInt() - 1;
				long lengthBetweenNodes = argumentScanner.nextLong();
				
				graph.get(leftNodeId).add(new CobNode(rightNodeId, lengthBetweenNodes));
				graph.get(rightNodeId).add(new CobNode(leftNodeId, lengthBetweenNodes));
			}
			
			CobMST solution = new CobMST(graph);
			solution.prim(0);

			System.out.println(LongStream.of(solution.distance).sum() * priceToPaveOneFurlongStreet);
			
		}
		
		argumentScanner.close();
	}
}

class CobNode implements Comparable<CobNode> {
	Integer id;
	Long dist;
	
	public CobNode(Integer id, Long dist) {
		this.id = id;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(CobNode other) {
		return this.dist.compareTo(other.dist);
	}
}	


class CobMST {
	
	public CobMST(List<List<CobNode>> graph) {
		this.graph = graph;
		int numberOfNode = graph.size();
		
		distance = new long[numberOfNode];
		path = new int[numberOfNode];
		visited = new boolean[numberOfNode];
		priorityQueue = new PriorityQueue<>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(path, -1);
		Arrays.fill(visited, false);
	}
	
	long[] distance;
	private int[] path;
	private boolean[] visited;
	private PriorityQueue<CobNode> priorityQueue;
	private List<List<CobNode>> graph;
	
	public void prim(int beginNodeIndex) {
		priorityQueue.add(new CobNode(beginNodeIndex, 0l));
		distance[beginNodeIndex] = 0;
		
		while (!priorityQueue.isEmpty()) {
			CobNode currentNode = priorityQueue.poll();
			
			visited[currentNode.id] = true;
			
			for (CobNode neighbor : graph.get(currentNode.id)) {
				if (!visited[neighbor.id] && neighbor.dist < distance[neighbor.id]) {
					distance[neighbor.id] = neighbor.dist;
					priorityQueue.add(new CobNode(neighbor.id,  neighbor.dist));
					path[neighbor.id] = currentNode.id;
				}
			}
		}
	}
	
	
}
