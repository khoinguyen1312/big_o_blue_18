package minimumspanningtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class RoadConstruction {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int numberOfProblem = argumentScanner.nextInt();
		
		for (int problem = 0; problem < numberOfProblem; problem++) {
			int numberOfStreet = argumentScanner.nextInt();

			Map<String, List<CityMST.Node>> citiesGraph = new HashMap<>();
			
			for (int i = 0; i < numberOfStreet; i++) {
				String leftCity = argumentScanner.next();
				String rightCity = argumentScanner.next();
				int distanceBetweenCities = argumentScanner.nextInt();
				
				if (!citiesGraph.containsKey(leftCity)) {
					citiesGraph.put(leftCity, new ArrayList<CityMST.Node>());
				}

				if (!citiesGraph.containsKey(rightCity)) {
					citiesGraph.put(rightCity, new ArrayList<CityMST.Node>());
				}

				citiesGraph.get(leftCity).add(CityMST.Node.createInstance(rightCity, distanceBetweenCities));
				citiesGraph.get(rightCity).add(CityMST.Node.createInstance(leftCity, distanceBetweenCities));
				
			}
			
			CityMST solution = new CityMST(citiesGraph);
			
			solution.prim(citiesGraph.entrySet().stream().findFirst().get().getKey());
			
			if (solution.distances.entrySet().stream().map(Entry::getValue).anyMatch(v -> v == Integer.MAX_VALUE)) {
				System.out.println("Case " + (problem + 1) + ": Impossible");
			} else {
				System.out.println("Case " + (problem + 1) + ": " + solution.distances.entrySet().stream().map(Entry::getValue).mapToInt(v -> v).sum());
			}
		}
		
		argumentScanner.close();
	}
}


class CityMST {
	public static class Node implements Comparable<Node> {
		String cityName;
		Integer distance;
		
		private Node(String id, Integer dist) {
			this.cityName = id;
			this.distance = dist;
		}
		
		public static Node createInstance(String id, Integer dist) {
			return new Node(id, dist);
		}
		
		@Override
		public int compareTo(Node other) {
			return this.distance.compareTo(other.distance);
		}
	}	
	
	public CityMST(Map<String, List<Node>> citiesGraph) {
		this.citiesGraph = citiesGraph;
		
		distances = new HashMap<>();
		path = new HashMap<>();
		visited = new HashSet<>();
		cityPriorityQueue = new PriorityQueue<>();
		
		for (Entry<String, List<Node>> city : citiesGraph.entrySet()) {
			distances.put(city.getKey(), Integer.MAX_VALUE);
			path.put(city.getKey(), "");
		}
	}
	
	Map<String, Integer> distances;
	Map<String, String> path;
	Set<String> visited;
	PriorityQueue<Node> cityPriorityQueue;
	Map<String, List<Node>> citiesGraph;
	
	public void prim(String beginCityName) {
		cityPriorityQueue.add(new Node(beginCityName, 0));
		distances.put(beginCityName, 0);
		
		while (!cityPriorityQueue.isEmpty()) {
			Node city = cityPriorityQueue.poll();
			visited.add(city.cityName);
			
			for (Node connectedCity : citiesGraph.get(city.cityName)) {
				if (!visited.contains(connectedCity.cityName) && connectedCity.distance < distances.get(connectedCity.cityName)) {
					distances.put(connectedCity.cityName, connectedCity.distance);
					
					cityPriorityQueue.add(new Node(connectedCity.cityName,  connectedCity.distance));
					
					path.put(connectedCity.cityName, city.cityName);
				}
			}
		}
	}
}
