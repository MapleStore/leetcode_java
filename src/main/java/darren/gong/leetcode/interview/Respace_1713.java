package darren.gong.leetcode.interview;

import java.util.HashSet;
import java.util.Set;

public class Respace_1713 {
  private class Node {
    boolean end = false;
    Node[] nodes = new Node[26];
  }

  private Node root = new Node();

  public static void main(String[] args) {
    Respace_1713 respace_1713 = new Respace_1713();
    respace_1713.respace(new String[]{"looked","just","like","her","brother"}, "jesslookedjustliketimherbrother");
  }

  public int respace(String[] dictionary, String sentence) {
    if (sentence == null || sentence.length() == 0) {
      return 0;
    }
    for (String word : dictionary) {
      add(word);
    }
    int length = sentence.length();
    int[] dp = new int[length];

    for (int i = 0; i < length; i++) {
      dp[i] = getResult(dp, sentence, i, root, Integer.MAX_VALUE, i);
    }
    return dp[length-1];
  }

  private void add(String word) {
    add(word, word.length()-1, root);
  }

  private void add(String word, int index, Node node) {
    if (index == -1) {
      node.end = true;
      return;
    }
    char current = word.charAt(index);
    Node next = node.nodes[current-'a'];
    if (next == null) {
      next = new Node();
      node.nodes[current-'a'] = next;
    }
    add(word, index-1, next);
  }

  private int getResult(int[] dp, String sentence, int index, Node node, int currentResult, int start) {
    if (index == -1) {
      return currentResult;
    }
    char current = sentence.charAt(index);
    Node next = node.nodes[current-'a'];
    if (next == null) {
      return Math.min(currentResult, start-index+1+(index == 0 ? 0 : dp[index-1]));
    }
    if (next.end) {
      return getResult(dp, sentence, index-1, next, Math.min(currentResult, index == 0 ? 0 : dp[index-1]), start);
    }
    return getResult(dp, sentence, index-1, next, Math.min(currentResult, start-index+1+(index == 0 ? 0 : dp[index-1])), start);
  }
}
