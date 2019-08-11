package finalexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PhoneList {
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int numberOfTest = argumentScanner.nextInt();
		
		for (int i = 0; i < numberOfTest; i++) {
			int numberOfPhoneNumber = argumentScanner.nextInt();
			List<String> phoneNumbers = new ArrayList<>();
			for (int j = 0; j < numberOfPhoneNumber; j++) {
				phoneNumbers.add(argumentScanner.next());
			}
			
			printSolution(phoneNumbers);
		}
		argumentScanner.close();
	}
	
	public static void printSolution(List<String> phoneNumbers) {
		Trie trie = new Trie();
		
		for (String phoneNumber : phoneNumbers) {
			boolean result = trie.addWord(phoneNumber, 1);
			if (!result) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
	}
}

class Trie {
	public static final int MAX = 10;

	public class Node {
		public Node[] child;
		public int countWord;
		public Node() {
			countWord = 0;
			child = new Node[MAX];
		}
	}
	
	private Node root;
	public Trie() {
		root = new Node();
	}
	
	public boolean addWord(String s, int count) {
		int ch;
		Node temp = root;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i) - '0';
			if (temp.child[ch] == null) {
				Node x = new Node();
				temp.child[ch] = x;
			}
			if (temp.countWord > 0) {
				temp.countWord++;
				if (temp.countWord >= 2) {
					return false;
				}
			}
			temp = temp.child[ch];
		}
		temp.countWord += count;
		return true;
	}
	
	private Optional<Node> findNode(String s) {
		int ch;
		Node temp = root;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i) - '0';
			if (temp.child[ch] == null) {
				return Optional.empty();
			}
			temp = temp.child[ch];
		}
		return Optional.of(temp);
	}
	
	public int findWord(String s) {
		Optional<Node> node = findNode(s);
		
		if (!node.isPresent()) {
			return 0;
		}
		
		return node.get().countWord;
	}
	
	private boolean isWord(Node pNode) {
		return pNode.countWord != 0;
	}
	
	private boolean isEmpty(Node pNode) {
		for (int i = 0; i < MAX; i++) {
			if (pNode.child[i] != null) {
				return false;
			}
		}
		return true;
	}
	
	public boolean removeWord(String s) {
		return removeWord(root, s, 0, s.length());
	}
	
	private boolean removeWord(Node root, String s, int level, int len) {
		if (root == null) {
			return false;
		}
		
		if (level == len) {
			if (root.countWord > 0) {
				root.countWord--;
				return true;
			}
			return false;
		}
		
		int ch = s.charAt(level) - '0';
		
		boolean flag = removeWord(root.child[ch],  s,  level + 1,  len);
		
		if (flag && !isWord(root.child[ch]) && isEmpty(root.child[ch])) {
			root.child[ch] = null;
		}
		
		return flag;
	}
	
	public void printWord() {
		printWord(root, "");
	}
	
	private void printWord(Node root, String s) {
		if (isWord(root)) {
			System.out.println(s);
		}
		
		for (int i = 0; i < MAX; i++) {
			if (root.child[i] != null) {
				printWord(root.child[i], s + i);
			}
		}
	}
}
