package darren.gong.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintTree655 {
  public List<List<String>> printTree(TreeNode root) {
    List<List<String>> result = new ArrayList<>();
    int height = countHeight(root);
    int width = 1;
    int temp = height;
    while (--temp > 0) {
      width = (width<<1)+1;
    }
    String[][] tempResult = new String[height][width];
    for (int i = 0; i < height; i++) {
      Arrays.fill(tempResult[i], "");
    }

    int rootIndex = width>>>1;
    tempResult[0][rootIndex] = root.val+"";
    if (root.left != null) {
      fillContent(root.left, rootIndex>>>1, rootIndex, 1, tempResult);
    }
    if (root.right != null) {
      fillContent(root.right, (rootIndex+width)>>>1, rootIndex, 1, tempResult);
    }

    for (int i = 0; i < height; i++) {
      result.add(Arrays.asList(tempResult[i]));
    }
    return result;
  }
  private void fillContent(TreeNode node, int currentY, int parentY, int currentX, String[][] result) {
    String[] line = result[currentX];
    line[currentY] = node.val+"";
    int distance = (Math.max(currentY, parentY)-Math.min(currentY, parentY))>>>1;
    if (node.left != null) {
      fillContent(node.left, currentY-distance, currentY, currentX+1, result);
    }
    if (node.right != null) {
      fillContent(node.right, currentY+distance, currentY, currentX+1, result);
    }
    return;
  }


  public List<List<String>> printTreeDFS(TreeNode root) {
    List<List<String>> result = new ArrayList<>();
    int height = countHeight(root);
    int width = 1;
    int temp = height;
    while (--temp > 0) {
      width = (width<<1)+1;
    }
    String[][] tempResult = new String[height][width];
    for (int i = 0; i < height; i++) {
      Arrays.fill(tempResult[i], "");
    }
    dfs(root, 0, width-1, 0, tempResult);
    for (int i = 0; i < height; i++) {
      result.add(Arrays.asList(tempResult[i]));
    }
    return result;
  }
  private void dfs(TreeNode node, int left, int right, int currentX, String[][] result) {
    if (node == null || left > right) {
      return;
    }
    String[] line = result[currentX];
    int index = (left+right)>>>1;
    line[index] = node.val+"";
    dfs(node.left, left, index-1, currentX+1, result);
    dfs(node.right, index+1, right, currentX+1, result);
    return;
  }

  private int countHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1+Math.max(countHeight(root.left), countHeight(root.right));
  }

}
