package finalexam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UbiquitousReligions {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int nextLeft = argumentScanner.nextInt();
		int nextRight = argumentScanner.nextInt();
		
		int problemCounter = 1;
		
		while (!(nextLeft == 0 && nextRight == 0)) {
			int numberOfStudent = nextLeft;
			int numberOfRelationShip = nextRight;

			DisjointSetUnion set = new DisjointSetUnion(numberOfStudent);
			
			Set<Integer> students = new HashSet();
			
			for (int i = 0; i < numberOfRelationShip; i++) {
				int left = argumentScanner.nextInt() - 1;
				int right = argumentScanner.nextInt() - 1;
				set.addConnection(left, right);
				students.add(left);
				students.add(right);
			}
			
			Map<Integer, Integer> religions = new HashMap<>();
			
			for (Integer student : students) {
				religions.add(set.findAncestor(student));
			}
			
			System.out.println("Case " + problemCounter + ": " + religions.size());

			nextLeft = argumentScanner.nextInt();
			nextRight = argumentScanner.nextInt();
			problemCounter++;
		}
	}
}

class DisjointSetUnion {
	private int[] parents;
	
	public DisjointSetUnion(int numberOfNode) {
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