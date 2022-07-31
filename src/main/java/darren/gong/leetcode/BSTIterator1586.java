package darren.gong.leetcode;

import java.util.Stack;

public class BSTIterator1586 {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(7);
    root.left = new TreeNode(3);
    root.right = new TreeNode(15);
    root.right.left = new TreeNode(9);
    root.right.right = new TreeNode(20);
    BSTIterator1586 bstIterator1586 = new BSTIterator1586(root);
    bstIterator1586.next(); // 状态变为 [<u>3</u>, 7, 9, 15, 20], 返回 3
    bstIterator1586.next(); // 状态变为 [3, <u>7</u>, 9, 15, 20], 返回 7
    //bstIterator1586.prev(); // 状态变为 [<u>3</u>, 7, 9, 15, 20], 返回 3
    //bstIterator1586.next(); // 状态变为 [3, <u>7</u>, 9, 15, 20], 返回 7
    //bstIterator1586.hasNext(); // 返回 true
    bstIterator1586.next(); // 状态变为 [3, 7, <u>9</u>, 15, 20], 返回 9
    bstIterator1586.next(); // 状态变为 [3, 7, 9, <u>15</u>, 20], 返回 15
    bstIterator1586.next(); // 状态变为 [3, 7, 9, 15, <u>20</u>], 返回 20
    bstIterator1586.hasNext(); // 返回 false
    bstIterator1586.hasPrev(); // 返回 true
    bstIterator1586.prev(); // 状态变为 [3, 7, 9, <u>15</u>, 20], 返回 15
    bstIterator1586.prev(); // 状态变为 [3, 7, <u>9</u>, 15, 20], 返回 9
  }

  private TreeNode head;
  private TreeNode pre;
  private TreeNode tail;
  private TreeNode current;
  public BSTIterator1586(TreeNode root) {
    visit(root);
    TreeNode newHead = new TreeNode(-1);
    newHead.right = head;
    head.left = newHead;
    head = newHead;

    TreeNode newTail = new TreeNode(-1);
    newTail.left = tail;
    tail.right = newTail;
    tail = newTail;

    current = head;
  }

  private void visit(TreeNode node) {
    if (node == null) {
      return;
    }
    visit(node.left);
    // set head
    if (head == null) {
      head = node;
    }
    // set link
    node.left = pre;
    if (pre != null) {
      pre.right = node;
    }
    pre = node;
    // set tail
    tail = node;
    visit(node.right);
  }

  public boolean hasNext() {
    return current != tail && current.right != tail;
  }

  public int next() {
    current = current.right;
    return current.val;
  }

  public boolean hasPrev() {
    return current != head && current.left != head;
  }

  public int prev() {
    current = current.left;
    return current.val;
  }
}
