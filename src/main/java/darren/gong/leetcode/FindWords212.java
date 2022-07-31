package darren.gong.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindWords212 {
  private class Node {
    Node[] nodes = new Node[26];
    boolean end = false;
  }
  private class Trie {
    private Node tree = new Node();
    public void insert(String word) {
      if (word == null) {
        return;
      }
      if (word.isEmpty()) {
        tree.end = true;
        return;
      }
      insertHelper(tree, word, 0);
    }
    public void insertHelper(Node tree, String word, int wordIndex) {
      if (wordIndex == word.length()) {
        tree.end = true;
        return;
      }
      int index = word.charAt(wordIndex)-'a';
      if (tree.nodes[index] == null) {
        tree.nodes[index] = new Node();
      }
      insertHelper(tree.nodes[index], word, wordIndex+1);
    }

    public Node search(String word) {
      if (word == null) {
        return null;
      }
      if (word.isEmpty()) {
        return tree;
      }
      int wordIndex = 0;
      Node current = tree;
      while (current != null && wordIndex < word.length()) {
        current = current.nodes[word.charAt(wordIndex)-'a'];
        wordIndex++;
      }
      return current;
    }
  }
  public static void main(String[] args) {
    FindWords212 findWords212 = new FindWords212();
    findWords212.findWords(new char[][]{{'a'}}, new String[]{"a"});
  }

  private static int[][] directions = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
  Trie trie = new Trie();
  public List<String> findWords(char[][] board, String[] words) {
    int maxX = board.length;
    int maxY = board[0].length;
    Set<String> result = new HashSet<>();
    for (String word : words) {
      trie.insert(word);
    }
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        boolean[][] visited = new boolean[maxX][maxY];
        visited[i][j] = true;
        dfs(visited, board, i, j, maxX, maxY, result, new StringBuilder().append(board[i][j]));
      }
    }
    return new LinkedList<>(result);
  }
  private void dfs(boolean[][] visited, char[][] board, int x, int y, int maxX, int maxY, Set<String> result, StringBuilder sb) {
    Node node = trie.search(sb.toString());
    if (node == null) {
      return;
    }
    if (node.end) {
      result.add(sb.toString());
    }
    for (int[] direction : directions) {
      int nextX = x+direction[0];
      int nextY = y+direction[1];
      if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY && !visited[nextX][nextY]) {
        sb.append(board[nextX][nextY]);
        visited[nextX][nextY] = true;
        dfs(visited, board, nextX, nextY, maxX, maxY, result, sb);
        visited[nextX][nextY] = false;
        sb.deleteCharAt(sb.length()-1);
      }
    }
    return;
  }
}
