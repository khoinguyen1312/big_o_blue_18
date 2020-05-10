package disjointsetunion;

import java.util.Scanner;
import java.util.stream.IntStream;

public class GraphConnectivity {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int numberOfProblem = Integer.parseInt(argumentScanner.nextLine());
		argumentScanner.nextLine();
		
		for (int problem = 0; problem < numberOfProblem; problem++) {
			if (problem != 0) {
				System.out.println();
			}
			
			String maximalNode = argumentScanner.nextLine();
			int numberOfNode = maximalNode.toCharArray()[0] - 'A' + 1;
			
			GraphConnectivityDSU set = new GraphConnectivityDSU(numberOfNode);
			
			String nextLine = argumentScanner.nextLine();
			while (!nextLine.trim().isEmpty() && argumentScanner.hasNext()) {
 				int leftNode = nextLine.toCharArray()[0] - 'A';
				int rightNode = nextLine.toCharArray()[1] - 'A';
				
				set.addConnection(leftNode, rightNode);
				nextLine = argumentScanner.nextLine();
			}
			
			int[] friendsCount = new int[numberOfNode];
			
			for (int i = 0; i < numberOfNode; i++) {
				friendsCount[i] = 0;
			}
			
			for (int i = 0; i < numberOfNode; i++) {
				int ancestor = set.findAncestor(i);
				friendsCount[ancestor]++;
			}
			
			System.out.println(IntStream.of(friendsCount).filter(i -> i != 0).count());
		}
		
		argumentScanner.close();
	}
}

class GraphConnectivityDSU {
	private int[] parents;
	
	public GraphConnectivityDSU(int numberOfNode) {
		parents = new int[numberOfNode];
		
		for (int i = 1; i < numberOfNode; i++) {
			parents[i] = i;
		}
	}
	
	private int findSet(int u) {
		while (u != parents[u]) {
			u = parents[u];
		}
		return u;
	}
	
	private void unionSet(int u, int v) {
		int up = findSet(u);
		int vp = findSet(v);
		
		parents[up] = vp;
	}
	
	public void addConnection(int u, int v) {
		unionSet(u, v);
	}
	
	public boolean isConnected(int u, int v) {
		return findSet(u) == findSet(v);
	}
	
	public int findAncestor(int u) {
		return findSet(u);
	}
}
