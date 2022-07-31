package darren.gong.leetcode;

class Noede {
    Noede[] child = new Noede[26];
    boolean isLeaf;
}

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
    }

    Noede root = new Noede();
    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) {
            return;
        }

        Noede currentNode = root;
        for (int index = 0; index < word.length(); index++) {
            int offset = word.charAt(index)-'a';
            if (currentNode.child[offset] == null) {
                currentNode.child[offset] = new Noede();
            }
            if (index == word.length()-1) {
                currentNode.child[offset].isLeaf = true;
            }
            currentNode = currentNode.child[offset];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        if (word.length() == 0) {
            return root.isLeaf;
        }
        Noede currentNode = root;
        int index = 0;
        for (index = 0; index < word.length(); index++) {
            int offset = word.charAt(index)-'a';
            currentNode = currentNode.child[offset];
            if (currentNode == null) {
                break;
            }
            if (index == word.length()-1 && currentNode.isLeaf) {
                return true;
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }
        Noede currentNode = root;
        int index = 0;
        for (index = 0; index < prefix.length(); index++) {
            int offset = prefix.charAt(index)-'a';
            if (currentNode.child[offset] == null) {
                break;
            }
            currentNode = currentNode.child[offset];
        }
        if (index >= prefix.length()) {
            return true;
        }
        return false;
    }

}
