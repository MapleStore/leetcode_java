package darren.gong.leetcode;

import java.util.Random;

public class Skiplist_1206 {
  public static void main(String[] args) {
    Skiplist_1206 skiplist_1206 = new Skiplist_1206();
    skiplist_1206.add(5);
    skiplist_1206.add(5);
    System.out.println(skiplist_1206.erase(5));
    System.out.println(skiplist_1206.search(5));
  }
  private static class SkipNode {
    private int val;
    private int count = 1;
    private SkipNode right;
    private SkipNode down;
    private SkipNode(int val) {
      this.val = val;
    }
  }
  private SkipNode[] skipNodes;
  private SkipNode head;
  private Random random = new Random();
  public Skiplist_1206() {
    skipNodes = new SkipNode[32];
    for (int i = 0; i < 32; i++) {
      skipNodes[i] = new SkipNode(-1);
    }
    for (int i = 0; i < 31; i++) {
      skipNodes[i].down = skipNodes[i+1];
    }
    head = skipNodes[0];
  }

  public boolean search(int target) {
    return search(head, target);
  }

  public boolean search(SkipNode node, int target) {
    if (node == null) {
      return false;
    }
    if (node.right == null || node.right.val > target) {
      return search(node.down, target);
    }
    if (node.right.val == target) {
      return true;
    }
    return search(node.right, target);
  }

  public void add(int num) {
    add(head, num);
  }

  public SkipNode add(SkipNode node, int num) {
    if (node.right == null || node.right.val > num) {
      if (node.down == null) {
        SkipNode add = new SkipNode(num);
        add.right = node.right;
        node.right = add;
        return add;
      }

      SkipNode downAdd = add(node.down, num);
      if (downAdd != null && random.nextDouble() < 0.5) {
        SkipNode add = new SkipNode(num);
        add.right = node.right;
        add.down = downAdd;
        node.right = add;
        return add;
      }
      return null;
    }
    if (node.right.val == num) {
      if (node.down != null) {
        add(node.down, num);
      }
      node.right.count++;
      return null;
    }
    return add(node.right, num);
  }

  public boolean erase(int num) {
    return erase(head, num);
  }

  private boolean erase(SkipNode node, int num) {
    if (node == null) {
      return false;
    }
    if (node.right == null || node.right.val > num) {
      return erase(node.down, num);
    }
    if (node.right.val == num) {
      node.right.count--;
      if (node.right.count <= 0) {
        node.right = node.right.right;
      }
      erase(node.down, num);
      return true;
    }
    return erase(node.right, num);
  }
}
