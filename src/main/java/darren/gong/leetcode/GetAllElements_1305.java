package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetAllElements_1305 {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> result1 = new ArrayList<>();
    dfs(root1, result1);
    List<Integer> result2 = new ArrayList<>();
    dfs(root2, result2);

    List<Integer> result = new LinkedList<>();
    int index1 = 0;
    int index2 = 0;
    int length1 = result1.size();
    int length2 = result2.size();
    while (index1 < length1 || index2 < length2) {
      if (index1 >= length1) {
        result.add(result2.get(index2));
        index2++;
        continue;
      }
      if (index2 >= length2) {
        result.add(result1.get(index1));
        index1++;
        continue;
      }
      int val1 = result1.get(index1);
      int val2 = result2.get(index2);
      if (val1 < val2) {
        result.add(val1);
        index1++;
      } else {
        result.add(val2);
        index2++;
      }
    }
    return result;
  }
  private void dfs(TreeNode node, List<Integer> result) {
    if (node == null) {
      return;
    }
    dfs(node.left, result);
    result.add(node.val);
    dfs(node.right, result);
  }
}
