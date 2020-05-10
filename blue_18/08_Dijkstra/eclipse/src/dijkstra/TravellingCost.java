package dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
	Integer id;
	Integer distance;
	
	Node(int id, int distance) {
		this.id = id;
		this.distance = distance;
	}

	@Override
	public int compareTo(Node beingCompared) {
		return this.distance.compareTo(beingCompared.distance);
	}
}
public class TravellingCost {
	public static int NUMBER_OF_CITY = 2000;
	public static int MAXIMUM_DISTANCE = Integer.MAX_VALUE;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
    	
    	List<List<Node>> graph = new ArrayList<>(NUMBER_OF_CITY);
    	for (int i = 0; i < NUMBER_OF_CITY; i++) {
    		graph.add(new ArrayList<>());
    	}
    	
    	int numberOfRoads = argumentScanner.nextInt();
		
		for (int j = 0; j < numberOfRoads; j++) {
			int left = argumentScanner.nextInt();
			int right = argumentScanner.nextInt();
			int cost = argumentScanner.nextInt();
			
			graph.get(left).add(new Node(right, cost));
			graph.get(right).add(new Node(left, cost));
		}
		
		int startingPoint = argumentScanner.nextInt();
		
		int numberOfQuery = argumentScanner.nextInt();
		List<Integer> queries = new ArrayList<>();
		
		for (int i = 0; i < numberOfQuery; i++) {
			queries.add(argumentScanner.nextInt());
		}
		
    	argumentScanner.close();
    	
    	int[] cost = costDijkstra(graph, startingPoint);
    	
    	for (Integer query : queries) {
    		if (cost[query] == MAXIMUM_DISTANCE) {
    			System.out.println("NO PATH");
    		} else {
    			System.out.println(cost[query]);
    		}
    	}
	}
	
	public static void test() {
	}
	
	public static int[] costDijkstra(List<List<Node>> graph, int startingPoint) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		int numberOfNode = graph.size();
		int[] cost = new int[numberOfNode];
		int[] path = new int[numberOfNode];
		
		for (int i = 0; i < numberOfNode; i++) {
			cost[i] = MAXIMUM_DISTANCE;
			path[i] = -1;
		}
		
		queue.add(new Node(startingPoint, 0));
		cost[startingPoint] = 0;
		
		while (!queue.isEmpty()) {
			Node checkingPoint = queue.poll();
			
			for (int i = 0; i < graph.get(checkingPoint.id).size(); i++) {
				Node neighbor = graph.get(checkingPoint.id).get(i);
				
				if (checkingPoint.distance + neighbor.distance < cost[neighbor.id]) {
					cost[neighbor.id] = checkingPoint.distance + neighbor.distance;
					queue.add(new Node(neighbor.id, cost[neighbor.id]));
					path[neighbor.id] = checkingPoint.id;
				}
			}
		}
		
		return cost;
	}
}
