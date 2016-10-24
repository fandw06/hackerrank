package datastructure;

import CrackingInterview.TrieContact;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Dawei on 10/13/2016.
 */
public class NoPrefix {
    class TrieNode {
        boolean isWord;
        public TrieNode children[] = new TrieNode['j'-'a'+1];
        public TrieNode() {}
    }

    TrieNode root;
    public NoPrefix() {
        root = new TrieNode();
    }

    public boolean insertAndCheck(String s) {

        TrieNode children[] = root.children;
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
            }
            curr = children[c - 'a'];
            if (curr.isWord)
                return true;
            children = curr.children;
        }
        curr.isWord = true;
        for (int i = 0; i<'c' -'a'+1; i++) {
            if (curr.children[i] != null)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("noprefix2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        NoPrefix np = new NoPrefix();
        int n = scanner.nextInt();
        boolean bad = false;
        for (int i = 0; i< n; i++) {
            String cc = scanner.next();
            boolean b = np.insertAndCheck(cc);
            if (b) {
                bad = true;
                System.out.println("BAD SET");
                System.out.println(cc);
                break;
            }
        }
        if (!bad)
            System.out.println("GOOD SET");

    }
}
