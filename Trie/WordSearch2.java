package Trie;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int idx = -1;
    int ref = 0;

    public void addWord(String word, int idx) {
        TrieNode curr = this;
        curr.ref++;

        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[word.charAt(i) - 'a'];
            curr.ref++;
        }
        curr.idx = idx;
    }
}

class WordSearch2 {
    private List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            root.addWord(words[i], i);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(root, r, c, board, words);
            }
        }

        return res;
    }

    private void dfs(TrieNode parentNode, int r, int c, char[][] board, String[] words) {
        // base condition
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '*'
                || parentNode.children[board[r][c] - 'a'] == null) {
            return;
        }

        char temp = board[r][c];
        board[r][c] = '*';
        TrieNode prev = parentNode;
        TrieNode current = parentNode.children[temp - 'a'];
        if (current.idx > -1) {
            res.add(words[current.idx]);
            current.idx = -1;
            current.ref--;
            if (current.ref == 0) {
                prev.children[temp - 'a'] = null;
                board[r][c] = temp;
                return;
            }
        }

        dfs(current, r + 1, c, board, words);
        dfs(current, r - 1, c, board, words);
        dfs(current, r, c + 1, board, words);
        dfs(current, r, c - 1, board, words);

        board[r][c] = temp;
    }

}
