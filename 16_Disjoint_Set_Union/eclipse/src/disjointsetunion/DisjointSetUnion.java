package disjointsetunion;

public class DisjointSetUnion {
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
