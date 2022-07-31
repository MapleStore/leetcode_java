package darren.gong.leetcode.interview;

public class ListOfDepth_0403 {
  // 面试题 04.03. 特定深度节点链表
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  private ListNode[] result;
  private ListNode[] tails;
  public ListNode[] listOfDepth(TreeNode tree) {
    int size = maxDepth(tree);
    result = new ListNode[size];
    tails = new ListNode[size];
    dfs(tree, 0);
    return result;
  }
  private void dfs(TreeNode node, int depth) {
    if (node == null) {
      return;
    }
    ListNode current = new ListNode(node.val);
    if (result[depth] == null) {
      result[depth] = current;
    } else {
      tails[depth].next = current;
    }
    tails[depth] = current;
    dfs(node.left, depth+1);
    dfs(node.right, depth+1);
  }
  private int maxDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return Math.max(maxDepth(node.left), maxDepth(node.right))+1;
  }
}
