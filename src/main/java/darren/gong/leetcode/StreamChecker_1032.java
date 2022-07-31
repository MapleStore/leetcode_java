package darren.gong.leetcode;

public class StreamChecker_1032 {
  private static class Node {
    boolean isWord;
    Node[] children = new Node[26];
    public Node() {

    }
  }
  private Node root = new Node();
  private StringBuilder sb = new StringBuilder();
  public StreamChecker_1032(String[] words) {
    for (String word : words) {
      add(word, word.length()-1, root);
    }
  }

  public boolean query(char letter) {
    sb.append(letter);
    return query(sb, sb.length()-1, root);
  }

  private boolean query(StringBuilder sb, int index, Node node) {
    if (index == -1) {
      return node.isWord;
    }
    char currentChar = sb.charAt(index);
    Node next = node.children[currentChar-'a'];
    if (next == null) {
      return false;
    }
    if (next.isWord) {
      return true;
    }
    return query(sb, index-1, next);
  }

  private void add(String word, int index, Node node) {
    if (index == -1) {
      node.isWord = true;
      return;
    }
    char currentChar = word.charAt(index);
    Node next = node.children[currentChar-'a'];
    if (next == null) {
      next = new Node();
      node.children[currentChar-'a'] = next;
    }
    add(word, index-1, next);
  }
}
