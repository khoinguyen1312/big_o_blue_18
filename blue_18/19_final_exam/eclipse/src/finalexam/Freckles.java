package finalexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class Freckles {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);

		int numberOfProblem = Integer.parseInt(argumentScanner.nextLine());

		for (int problem = 0; problem < numberOfProblem; problem++) {
			if (problem != 0) {
				System.out.println();
			}

			argumentScanner.nextLine();

			String nextLine = argumentScanner.nextLine();
			int numberOfNode = Integer.parseInt(nextLine);

			double x[] = new double[numberOfNode];
			double y[] = new double[numberOfNode];

			for (int i = 0; i < numberOfNode; i++) {
				String[] result = argumentScanner.nextLine().split(" ");
				x[i] = Double.parseDouble(result[0]);
				y[i] = Double.parseDouble(result[1]);
			}

			solution(numberOfNode, x, y);
		}
		argumentScanner.close();
	}

	private static void solution(int numberOfNode, double[] x, double[] y) {
		List<List<MSTNode>> graph = new ArrayList<>();

		for (int i = 0; i < numberOfNode; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < numberOfNode; i++) {
			for (int j = 0; j < numberOfNode; j++) {
				if (i != j) {
					int leftNodeId = i;
					int rightNodeId = j;
					double lengthBetweenNodes = lengthBetweenPoints(x, y, i, j);

					graph.get(leftNodeId).add(new MSTNode(rightNodeId, lengthBetweenNodes));
					graph.get(rightNodeId).add(new MSTNode(leftNodeId, lengthBetweenNodes));
				}
			}
		}

		MST solution = new MST(graph);
		solution.prim(0);
		System.out.printf("%.2f\n", DoubleStream.of(solution.distance).sum());
	}

	private static double lengthBetweenPoints(double[] x, double[] y, int i, int j) {
		return Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
	}
}

class MSTNode implements Comparable<MSTNode> {
	Integer id;
	Double dist;

	MSTNode(Integer id, Double dist) {
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
	public PriorityQueue<MSTNode> priorityQueue;
	public List<List<MSTNode>> graph;

	public void prim(int beginNodeIndex) {
		priorityQueue.add(new MSTNode(beginNodeIndex, 0.0));
		distance[beginNodeIndex] = 0;

		while (!priorityQueue.isEmpty()) {
			MSTNode currentNode = priorityQueue.poll();

			visited[currentNode.id] = true;

			for (MSTNode neighbor : graph.get(currentNode.id)) {
				if (!visited[neighbor.id] && neighbor.dist < distance[neighbor.id]) {
					distance[neighbor.id] = neighbor.dist;
					priorityQueue.add(new MSTNode(neighbor.id, neighbor.dist));
					path[neighbor.id] = currentNode.id;
				}
			}
		}
	}
}
