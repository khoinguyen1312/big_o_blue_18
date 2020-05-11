package BackTracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int k = argumentScanner.nextInt();
		
		while (k != 0) {
			int[] s = new int[k];
			
			for (int i = 0; i < k; i++) {
				s[i] = argumentScanner.nextInt();
			}
			
			
			Arrays.sort(s);
			
			Set<Integer> lottos = new HashSet<>();
			findSolution(lottos, s, 0);
			System.out.println();

			k = argumentScanner.nextInt();
		}
		
		argumentScanner.close();
	}

	private static void findSolution(Set<Integer> lottos, int[] s, int left) {
		if (lottos.size() ==  6) {
			System.out.println(
					lottos.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "))
				);
		} else {
			for (int i = left; i < s.length; i++) {
				lottos.add(s[i]);
				findSolution(lottos, s, i + 1);
				lottos.remove(s[i]);
			}
		}
	}
}
