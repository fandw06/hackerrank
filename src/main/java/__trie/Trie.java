package __trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Dawei on 10/7/2016.
 */

// http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
public class Trie {
    public class TrieNode {
        public char val;
        boolean isWord;
        public Map<Character, TrieNode> children = new HashMap<>();
        public TrieNode() {}
        public TrieNode(char val) {
            this.val = val;
        }
    }

    // Empty
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode curr = root;
        Map<Character, TrieNode> children = curr.children;
        for (char c : s.toCharArray()) {
            if (children.containsKey(c)) {
                curr = children.get(c);
            }
            else {
                curr = new TrieNode(c);
                children.put(c, curr);
            }
            children = curr.children;
        }
        curr.isWord = true;
    }

    public boolean contains(String s) {
        TrieNode curr = root;
        Map<Character, TrieNode> children = curr.children;
        for (char c : s.toCharArray()) {
            if (children.containsKey(c)) {
                curr = children.get(c);
                children = curr.children;
            }
            else
                return false;
        }
        return curr.isWord;
    }

    public boolean startWith(String s) {
        TrieNode curr = root;
        Map<Character, TrieNode> children = curr.children;
        for (char c : s.toCharArray()) {
            if (children.containsKey(c)) {
                curr = children.get(c);
                children = curr.children;
            }
            else
                return false;
        }
        return true;
    }

    public int numStartWith(String prefix) {
        TrieNode curr = root;
        Map<Character, TrieNode> children = curr.children;
        for (char c : prefix.toCharArray()) {
            if (children.containsKey(c)) {
                curr = children.get(c);
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
            queue.addAll(node.children.values());
        }
        return result;
    }

}
