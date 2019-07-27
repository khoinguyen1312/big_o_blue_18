package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Trie {
	public static final int MAX = 'z' - 'a' + 1;

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
	
	public List<Node> findWithPrefix(String prefix) {
		Optional<Node> optionalPrefixNode = findNode(prefix);
		
		if (!optionalPrefixNode.isPresent()) {
			return Collections.emptyList();
		}
		
		Node prefixNode = optionalPrefixNode.get();
		List<Node> nodeBelongToPrefix = new ArrayList<>();
		
		addIfIsNode(prefixNode, nodeBelongToPrefix);
	}
	
	private void addIfIsNode(Node prefixNode, List<Node> result) {
		f
	}
	
	public void addWord(String s, int count) {
		int ch;
		Node temp = root;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i) - 'a';
			if (temp.child[ch] == null) {
				Node x = new Node();
				temp.child[ch] = x;
			}
			temp = temp.child[ch];
		}
		temp.countWord += count;
	}
	
	private Optional<Node> findNode(String s) {
		int ch;
		Node temp = root;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i) - 'a';
			if (temp.child[ch] == null) {
				return Optional.empty();
			}
			temp = temp.child[ch];
		}
		return Optional.of(temp);
	}
	
	public boolean findWord(String s) {
		Optional<Node> node = findNode(s);
		
		if (!node.isPresent()) {
			return false;
		}
		
		return node.get().countWord > 0;
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
		
		int ch = s.charAt(level) - 'a';
		
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
				printWord(root.child[i], s + (char)('a' + i));
			}
		}
	}
}
