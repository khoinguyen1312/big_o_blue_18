package finalexam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MuhAndImportantThings {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int numberOfTasks = argumentScanner.nextInt();
		int[] tasks = new int[numberOfTasks];
		
		for (int i = 0; i < numberOfTasks; i++) {
			tasks[i] = argumentScanner.nextInt();
		}
		
		argumentScanner.close();
		
		TreeMap<Integer, Set<Integer>> map = new TreeMap();
		
		for (int i = 0; i < numberOfTasks; i++) {
			if (!map.containsKey(tasks[i])) {
				map.put(tasks[i], new HashSet<>());
			}
			
			map.get(tasks[i]).add(i);
		}
		
		if (map.entrySet().stream().filter(e -> e.getValue().size() >= 2).count() >= 2) {
			System.out.println("YES");
			List<List<Integer>> prints = new ArrayList<>();
			prints.add(new ArrayList<>());
			prints.add(new ArrayList<>());
			prints.add(new ArrayList<>());
			for (Entry<Integer, Set<Integer>> entry : map.entrySet()) {
				if (entry.getValue().size() == 1) {
					for (List<Integer> print : prints) {
						print.add((Integer) entry.getValue().toArray()[0]);
					}
				} else if (entry.getValue().size() == 2) {
					prints.get(0).add((Integer) entry.getValue().toArray()[0]);
					prints.get(0).add((Integer) entry.getValue().toArray()[1]);
					
					prints.get(1).add((Integer) entry.getValue().toArray()[1]);
					prints.get(1).add((Integer) entry.getValue().toArray()[0]);
					
					prints.get(2).add((Integer) entry.getValue().toArray()[1]);
					prints.get(2).add((Integer) entry.getValue().toArray()[0]);
				} else if (entry.getValue().size() >= 3) {
					prints.get(0).add((Integer) entry.getValue().toArray()[0]);
					prints.get(0).add((Integer) entry.getValue().toArray()[1]);
					prints.get(0).add((Integer) entry.getValue().toArray()[2]);

					prints.get(1).add((Integer) entry.getValue().toArray()[0]);
					prints.get(1).add((Integer) entry.getValue().toArray()[2]);
					prints.get(1).add((Integer) entry.getValue().toArray()[1]);

					prints.get(2).add((Integer) entry.getValue().toArray()[1]);
					prints.get(2).add((Integer) entry.getValue().toArray()[0]);
					prints.get(2).add((Integer) entry.getValue().toArray()[2]);
					
					for (int i = 3; i <  entry.getValue().size(); i++) {
						prints.get(0).add((Integer) entry.getValue().toArray()[i]);
						prints.get(1).add((Integer) entry.getValue().toArray()[i]);
						prints.get(2).add((Integer) entry.getValue().toArray()[i]);
					}
				}
			}
			
			System.out.println(prints);
		} else {
			System.out.println("NO");
		}
	}
}
