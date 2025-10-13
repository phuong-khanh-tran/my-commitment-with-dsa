package Trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    Boolean endOfWord = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        return searchHelper(current, word, 0);
    }

    private boolean searchHelper(TrieNode child, String word, int index) {
        // Base case
        if (index == word.length()) {
            if (child.endOfWord) {
                return true;
            }
            return false;
        }

        TrieNode current = child;
        Character c = word.charAt(index);
        if (c == '.') {
            for (TrieNode node : current.children.values()) {
                if (searchHelper(node, word, index + 1)) {
                    return true;
                }
            }
        } else if (current.children.containsKey(c)) {
            current = current.children.get(c);
            return searchHelper(current, word, index + 1);
        }

        return false;
    }
}
