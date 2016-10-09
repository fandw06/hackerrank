package __trie;

/**
 * Created by Dawei on 10/7/2016.
 */
public class Main {


    public static void testTrie() {
        Trie trie = new Trie();
        trie.insert("he");
        trie.insert("hell");
        System.out.println(trie.contains("he"));
        System.out.println(trie.contains("hell"));
        System.out.println(trie.contains("hel"));
        System.out.println(trie.startWith("hel"));
        trie.insert("hey");
        trie.insert("hi");
        trie.insert("his");
        trie.insert("hit");
        trie.insert("hip");

        System.out.println(trie.numStartWith("hi"));
    }

    public static void testWordTrie() {
        WordTrie trie = new WordTrie();
        trie.insert("he");
        trie.insert("hell");
        System.out.println(trie.contains("he"));
        System.out.println(trie.contains("hell"));
        System.out.println(trie.contains("hel"));
        System.out.println(trie.startWith("hel"));
        trie.insert("hey");
        trie.insert("hi");
        trie.insert("his");
        trie.insert("hit");
        trie.insert("hip");
        System.out.println(trie.numStartWith("hi"));
    }

    public static void main(String[] args) {
    //    testTrie();
        testWordTrie();
    }
}
