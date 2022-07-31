package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class AllPossibleFBT_897 {
  public static void main(String[] args) {
    AllPossibleFBT_897 allPossibleFBT_897 = new AllPossibleFBT_897();
    allPossibleFBT_897.allPossibleFBT(7);
  }
  public List<TreeNode> allPossibleFBT(int n) {
    List<TreeNode> result = new LinkedList<>();
    if (n == 1) {
      TreeNode node = new TreeNode(0);
      result.add(node);
      return result;
    }
    n--;
    int leftNum = 1;
    while (leftNum < n) {
      List<TreeNode> left = allPossibleFBT(leftNum);
      List<TreeNode> right = allPossibleFBT(n-leftNum);
      for (TreeNode oneLeft : left) {
        for (TreeNode oneRight : right) {
          TreeNode node = new TreeNode(0);
          node.left = oneLeft;
          node.right = oneRight;
          result.add(node);
        }
      }
      leftNum += 2;
    }
    return result;
  }
}
