package Trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (!current.children.containsKey(c)) {
                return false;
            } else {
                current = current.children.get(c);
            }
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (!current.children.containsKey(c)) {
                return false;
            } else {
                current = current.children.get(c);
            }
        }
        return true;
    }
}
