package __trie;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dawei on 10/7/2016.
 */
public class WordTrie {

    public class TrieNode {
        boolean isWord;
        public TrieNode children[] = new TrieNode[26];
        public TrieNode() {}
    }

    // Empty
    TrieNode root;
    public WordTrie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode curr = root;
        TrieNode children[] = curr.children;
        for (char c : s.toCharArray()) {
            if (children[c - 'a'] != null) {
                curr = children[c - 'a'];
            }
            else {
                curr = new TrieNode();
                children[c - 'a'] = curr;
            }
            children = curr.children;
        }
        curr.isWord = true;
    }

    public boolean contains(String s) {
        TrieNode curr = root;
        TrieNode children[] = curr.children;
        for (char c : s.toCharArray()) {
            if (children[c - 'a'] != null) {
                curr = children[c - 'a'];
                children = curr.children;
            }
            else
                return false;
        }
        return curr.isWord;
    }

    public boolean startWith(String s) {
        TrieNode curr = root;
        TrieNode children[] = curr.children;
        for (char c : s.toCharArray()) {
            if (children[c - 'a'] != null) {
                curr = children[c - 'a'];
                children = curr.children;
            }
            else
                return false;
        }
        return true;
    }

    public int numStartWith(String prefix) {
        TrieNode curr = root;
        TrieNode children[] = curr.children;
        for (char c : prefix.toCharArray()) {
            if (children[c - 'a'] != null) {
                curr = children[c - 'a'];
                children = curr.children;
            }
            else
                return 0;
        }
        // curr is the root of all words begin with, including prefix.
        int result = 0;
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(curr);
        while (!queue.isEmpty()) {
            TrieNode node = queue.remove();
            if (node.isWord)
                result++;
            for (TrieNode t : node.children) {
                if (t != null)
                    queue.add(t);
            }
        }
        return result;
    }
}
