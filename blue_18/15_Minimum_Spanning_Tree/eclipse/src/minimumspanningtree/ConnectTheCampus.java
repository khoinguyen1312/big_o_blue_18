package minimumspanningtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class ConnectTheCampus {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		while(argumentScanner.hasNext()) {
			int numberOfBuilding = argumentScanner.nextInt();
			int x[] = new int[numberOfBuilding];
			int y[] = new int[numberOfBuilding];
			
			for (int i = 0; i < numberOfBuilding; i++) {
				x[i] = argumentScanner.nextInt();
				y[i] = argumentScanner.nextInt();
			}
			
			List<List<CampusNode>> graph = new ArrayList<>();
			
			for (int i = 0; i < numberOfBuilding; i++) {
				graph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < numberOfBuilding; i++) {
				for (int j = 0; j < numberOfBuilding; j++) {
					if (i != j) {
						int leftNodeId = i;
						int rightNodeId = j;
						double lengthBetweenNodes = Math.sqrt((x[i] - x[j])*(x[i] - x[j]) + (y[i] - y[j])*(y[i] - y[j]));
						
						graph.get(leftNodeId).add(new CampusNode(rightNodeId, lengthBetweenNodes));
						graph.get(rightNodeId).add(new CampusNode(leftNodeId, lengthBetweenNodes));
					}
				}
			}
			
			
			int numberOfExistingCable = argumentScanner.nextInt();
			
			for (int i = 0; i < numberOfExistingCable; i++) {
				int leftId = argumentScanner.nextInt() - 1;
				int rightId = argumentScanner.nextInt() - 1;
				
				graph.get(leftId).stream().filter(n -> n.id == rightId).findFirst().get().dist = 0.0;
				graph.get(rightId).stream().filter(n -> n.id == leftId).findFirst().get().dist = 0.0;
			}
			
			CampusMST solution = new CampusMST(graph);
			solution.prim(0);
			System.out.println(String.format("%.2f", DoubleStream.of(solution.distance).sum()));
		}
		
		argumentScanner.close();
	}
}

class CampusNode implements Comparable<CampusNode> {
	Integer id;
	Double dist;
	
	CampusNode(Integer id, Double dist) {
		this.id = id;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(CampusNode other) {
		return this.dist.compareTo(other.dist);
	}
}	

class CampusMST {
	
	public CampusMST(List<List<CampusNode>> graph) {
		this.graph = graph;
		int numberOfNode = graph.size();
		
		priorityQueue = new PriorityQueue<>();
		
		distance = new double[numberOfNode];
		path = new int[numberOfNode];
		visited = new boolean[numberOfNode];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(path, -1);
		Arrays.fill(visited, false);
	}
	
	public double[] distance;
	public int[] path;
	public boolean[] visited;
	public PriorityQueue<CampusNode> priorityQueue;
	public List<List<CampusNode>> graph;
	
	public void prim(int beginNodeIndex) {
		priorityQueue.add(new CampusNode(beginNodeIndex, 0.0));
		distance[beginNodeIndex] = 0;
		
		while (!priorityQueue.isEmpty()) {
			CampusNode currentNode = priorityQueue.poll();
			
			visited[currentNode.id] = true;
			
			for (CampusNode neighbor : graph.get(currentNode.id)) {
				if (!visited[neighbor.id] && neighbor.dist < distance[neighbor.id]) {
					distance[neighbor.id] = neighbor.dist;
					priorityQueue.add(new CampusNode(neighbor.id,  neighbor.dist));
					path[neighbor.id] = currentNode.id;
				}
			}
		}
	}
	
	
}
