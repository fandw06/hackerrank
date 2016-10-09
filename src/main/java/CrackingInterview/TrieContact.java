package CrackingInterview;

import __trie.WordTrie;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dawei on 10/7/2016.
 */
public class TrieContact {
    public class TrieNode {
        boolean isWord;
        int sum = 0;
        public TrieNode children[] = new TrieNode[26];
        public TrieNode() {}
    }
    TrieNode root;
    public TrieContact() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode curr = root;
        TrieNode children[] = curr.children;
        for (char c : s.toCharArray()) {
            if (children[c - 'a'] != null) {
                curr = children[c - 'a'];
                curr.sum++;
            }
            else {
                curr = new TrieNode();
                children[c - 'a'] = curr;
                curr.sum++;
            }
            children = curr.children;
        }
        curr.isWord = true;
    }

    public int find(String prefix) {
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
        return curr.sum;
    }

    public static void main(String[] args) {
        TrieContact trie = new TrieContact();
        trie.insert("he");
        trie.insert("hell");
        trie.insert("hey");
        trie.insert("hi");
        trie.insert("his");
        trie.insert("hit");
        trie.insert("hip");
        System.out.println(trie.find("h"));
    }
}
