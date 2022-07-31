package darren.gong.leetcode;

import java.util.Arrays;

public class ValidateBinaryTreeNodes_1361 {
  // 1361. 验证二叉树
  private int count = 0;
  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    int[] parent = new int[n];
    Arrays.fill(parent, -1);
    for (int i = 0; i < n; i++) {
      if (leftChild[i] != -1) {
        if (parent[leftChild[i]] != -1) {
          return false;
        }
        parent[leftChild[i]] = i;
      }
      if (rightChild[i] != -1) {
        if (parent[rightChild[i]] != -1) {
          return false;
        }
        parent[rightChild[i]] = i;
      }
    }
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (parent[i] == -1) {
        return dfs(visited, i, leftChild, rightChild) && count == n;
      }
    }
    return false;
  }
  private boolean dfs(boolean[] visited, int current, int[] leftChild, int[] rightChild) {
    if (visited[current]) {
      return false;
    }
    count++;
    if (leftChild[current] != -1 && !dfs(visited, leftChild[current], leftChild, rightChild)) {
      return false;
    }
    if (rightChild[current] != -1 && !dfs(visited, rightChild[current], leftChild, rightChild)) {
      return false;
    }
    return true;
  }
}
