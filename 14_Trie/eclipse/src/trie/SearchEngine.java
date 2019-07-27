package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SearchEngine {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int numberOfData = argumentScanner.nextInt();
		int numberOfQueries = argumentScanner.nextInt();
		
		Map<String, Integer> data = new HashMap<>();
		List<String> queries = new ArrayList<>();
		
		for (int i = 0; i < numberOfData; i++) {
			data.put(argumentScanner.next(), argumentScanner.nextInt());
		}
		
		for (int i = 0; i < numberOfQueries; i++) {
			queries.add(argumentScanner.next());
		}
		
		argumentScanner.close();
		
		printMaximum(data, queries);
	}
	
	public static void printMaximum(Map<String, Integer> data, List<String> queries) {
		Trie trie = new Trie();
		
		for (Entry<String, Integer> entry : data.entrySet()) {
			trie.addWord(entry.getKey(), entry.getValue());
		}
		
		for (String query : queries) {
			trie.findWord(query);
		}
	}
}
