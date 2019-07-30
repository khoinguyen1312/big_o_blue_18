package floyd;

public class FloydWarshall {
	public static final int INF = Short.MAX_VALUE;
	public int[][] path;
	public int[][] dist;
	public int[][] grapth;
	
	public FloydWarshall(int[][] grapth) {
		int numberOfNode = grapth.length;
		
		this.path = new int [numberOfNode][numberOfNode];
		this.dist = new int [numberOfNode][numberOfNode];
		this.grapth = new int [numberOfNode][numberOfNode];
		
		for (int i = 0; i < numberOfNode; i++) {
			for (int j = 0; j < numberOfNode; j++) {
				this.grapth[i][j] = grapth[i][j];
				this.dist[i][j] = grapth[i][j];
				
				if (grapth[i][j] != INF && i != j) {
					path[i][j] = i;
				} else {
					path[i][j] = - 1;
				}
			}
		}
	}
	
	public boolean floydWarshall() {
		int numberOfNode = this.grapth.length;
		
		for (int  k = 0; k < numberOfNode; k++) {
			for (int i = 0; i < numberOfNode; i++) {
				for (int j = 0; j < numberOfNode; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						path[i][j] = path[k][j];
					}
				}
			}
		}
		
		for (int i = 0; i < numberOfNode; i++) {
			if (dist[i][i] < 0) {
				return false;
			}
		}
		
		return true;
	}
}
