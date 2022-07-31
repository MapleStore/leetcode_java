package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NextLargerNodes_1019 {
  // 1019. 链表中的下一个更大节点
  private Stack<int[]> stack = new Stack<>();
  private List<int[]> tempResult = new LinkedList<>();
  public int[] nextLargerNodes(ListNode head) {
    nextLargerNodesHelper(head, 0);
    int[] result = new int[tempResult.size()];
    for (int[] oneResult : tempResult) {
      result[oneResult[0]] = oneResult[1];
    }
    return result;
  }
  public void nextLargerNodesHelper(ListNode node, int index) {
    if (node == null) {
      while (!stack.isEmpty()) {
        tempResult.add(new int[]{stack.pop()[0], 0});
      }
      return;
    }
    while (!stack.isEmpty() && stack.peek()[1] < node.val) {
      int[] small = stack.pop();
      tempResult.add(new int[]{small[0], node.val});
    }
    stack.push(new int[]{index, node.val});
    nextLargerNodesHelper(node.next, index+1);
  }
}
