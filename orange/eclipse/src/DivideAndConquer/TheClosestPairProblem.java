package DivideAndConquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TheClosestPairProblem {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int n = argumentScanner.nextInt();
		
		while (n != 0) {
			if (n == 0) {
				break;
			}
			
			List<Point> points = new ArrayList<>(n);
			
			for (int i = 0; i < n; i++) {
				Point point = new Point(argumentScanner.nextInt(), argumentScanner.nextInt());
				points.add(point);
			}
			
			double min = closestPair(points, 0, n-1); 
			if (min < 10000.0) {
				System.out.println(String.format("%.4f", min));
			} else {
				System.out.println("INFINITY");
			}
			
			n = argumentScanner.nextInt();
		}
		
		argumentScanner.close();
	}

	private static double closestPair(List<Point> points, int left, int right) {
		if (left == right) {
			return Double.MAX_VALUE;
		}
		
		if (right - left <= 1) {
			return points.get(left).distanceTo(points.get(right));
		} else {
			int mid = (right + left) / 2;
			double closestPairLeft = closestPair(points, left, mid - 1);
			double closestPairRight = closestPair(points, mid, right);
			double min = Math.min(closestPairLeft, closestPairRight);
			return Math.min(
					min, 
					closestFromLeftToRight(points, left, right, min));
			
		}
	}
	
	private static double closestFromLeftToRight(List<Point> points, int left, int right, double min) {
		int mid = (right + left) / 2;
		
		List<Point> maybeSmallerThanMinPoints = new ArrayList<>();
		
		for (int i = left; i < right; i++) {
			if (Math.abs(points.get(i).x - points.get(mid).x) < min) {
				maybeSmallerThanMinPoints.add(points.get(i));
			}
		}
		
		Collections.sort(maybeSmallerThanMinPoints, (p1, p2) -> Double.compare(p1.y, p2.y));
		
		for (int i = 0; i < maybeSmallerThanMinPoints.size(); i++) {
			for (int j = i + 1; j < maybeSmallerThanMinPoints.size(); j++) {
				if (maybeSmallerThanMinPoints.get(j).y - maybeSmallerThanMinPoints.get(i).y > min) {
					break;
				}
				min = Math.min(
						min,
						maybeSmallerThanMinPoints
							.get(j)
							.distanceTo(
									maybeSmallerThanMinPoints.get(i)
									)
					);
			}
		}
		
		return min;
	}
}

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double distanceTo(Point b) {
		int x = this.x - b.x;
		int y = this.y - b.y;
		return Math.sqrt(x*x + y*y);
	}
}
