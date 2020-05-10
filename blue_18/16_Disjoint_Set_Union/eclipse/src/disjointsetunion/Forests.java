package disjointsetunion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Forests {
	public static void main(String[] args) {
		int numberOfPerson = 3;
		int numberOfTree = 4;

		int[] persons = new int[] { 3, 1, 3, 1, 2, 3, 2 };
		int[] treeIdeas = new int[] { 4, 2, 3, 3, 2, 2, 4 };

		Map<Integer, Set<Integer>> sets = new HashMap<>();
		
		for (int i = 0; i < numberOfTree + 1; i++) {
			sets.put(i, new HashSet<>());
		}
		
		for (int i = 0; i < persons.length; i++) {
			sets.get(treeIdeas[i]).add(persons[i]);
		}

		DisjointSetUnion set = new DisjointSetUnion(numberOfPerson);
		
		for (Entry<Integer, Set<Integer>> entry : sets.entrySet()) {
			Object[] treeIdeaPersons = entry.getValue().toArray();
			if (treeIdeaPersons.length > 1) {
				Integer first = (Integer) treeIdeaPersons[0];
				set.addConnection(first, first);
				for (int j = 1; j < treeIdeaPersons.length; j++) {
					set.addConnection(first, (Integer) treeIdeaPersons[j]);
				}
				
			} else if (treeIdeaPersons.length == 1) {
				set.addConnection((Integer) treeIdeaPersons[0], (Integer) treeIdeaPersons[0]);
			}
		}
		System.out.println();
		
		
		/*
		 * 
		 */
		
	}
}
