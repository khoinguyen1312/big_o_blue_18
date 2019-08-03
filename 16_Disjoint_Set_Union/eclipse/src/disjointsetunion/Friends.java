package disjointsetunion;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Friends {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int numberOfProblem = argumentScanner.nextInt();
		
		for (int problem = 0; problem < numberOfProblem; problem++) {
			int numberOfCitizen = argumentScanner.nextInt();
			int numberOfRelationship = argumentScanner.nextInt();
			
			DSU set = new DSU(numberOfCitizen);
			
			for (int i = 0; i < numberOfRelationship; i++) {
				set.addConnection(
						argumentScanner.nextInt() -1,
						argumentScanner.nextInt() - 1
						);
			}
			
			int[] friendsCount = new int[numberOfCitizen];
			
			for (int i = 0; i < numberOfCitizen; i++) {
				friendsCount[i] = 0;
			}
			
			for (int i = 0; i < numberOfCitizen; i++) {
				int ancestor = set.findAncestor(i);
				friendsCount[ancestor]++;
			}
			
			System.out.println(IntStream.of(friendsCount).max().getAsInt());
		}
		
		argumentScanner.close();
	}
}

class DSU {
	private int[] parents;
	
	public DSU(int numberOfNode) {
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
