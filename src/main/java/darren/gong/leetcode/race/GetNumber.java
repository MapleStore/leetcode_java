package darren.gong.leetcode.race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GetNumber {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public static void main(String[] args) {
    GetNumber getNumber = new GetNumber();
    getNumber.getNumber(new int[]{0,2,4,21,23,35,47},
        new int[][]{{1,0,47},{0,2,47}});
  }

  public class MyTreeNode {
    int all;
    int redCount;
    int flag;// no:0 red:1 blue:2
    MyTreeNode left;
    MyTreeNode right;
    public MyTreeNode(int all) {
      this.all = all;
    }
    public MyTreeNode() {

    }
  }

  public int getNumber(int[] nums, int[][] ops) {
    MyTreeNode node = buildTree(0, nums.length-1);
    for (int[] op : ops) {
      draw(node, 0, nums.length-1,
          getLeftIndex(nums, op[1]), getRightIndex(nums, op[2]), op[0]==1);
    }
    return node.redCount;
  }

  public int getNumber(TreeNode root, int[][] ops) {
    List<TreeNode> list = new ArrayList<>();
    addToList(root, list);
    int[] nums = new int[list.size()];
    int index = 0;
    for (TreeNode node : list) {
      nums[index++] = node.val;
    }

    MyTreeNode node = buildTree(0, list.size()-1);
    for (int[] op : ops) {
      draw(node, 0, list.size()-1,
          getLeftIndex(nums, op[1]), getRightIndex(nums, op[2]), op[0]==1);
    }
    return node.redCount;
  }
  private void draw(MyTreeNode node, int left, int right, int drawLeft, int drawRight, boolean red) {
    if (left > right) {
      return;
    }
    if (left == right) {
      if (red) {
        node.redCount = 1;
      } else {
        node.redCount = 0;
      }
      return;
    }
    if (drawLeft <= left && drawRight >= right) {
      if (red) {
        node.redCount = node.all;
        node.flag = 1;
      } else {
        node.redCount = 0;
        node.flag = 2;
      }
      return;
    }
    spread(node);
    int mid = (left+right)>>1;
    if (drawLeft <= mid) {
      draw(node.left, left, mid, drawLeft, drawRight, red);
    }
    if (drawRight >= mid+1) {
      draw(node.right, mid+1, right, drawLeft, drawRight, red);
    }
    node.redCount = node.right.redCount+node.left.redCount;
  }
  private void spread(MyTreeNode node) {
    if (node.flag == 1) {
      node.left.redCount = node.left.all;
      node.left.flag = 1;
      node.right.redCount = node.right.all;
      node.right.flag = 1;
    } else if (node.flag == 2) {
      node.left.redCount = 0;
      node.left.flag = 2;
      node.right.redCount = 0;
      node.right.flag = 2;
    }
    node.flag = 0;
  }
  private MyTreeNode buildTree(int left, int right) {
    if (left > right) {
      return new MyTreeNode();
    }
    if (left == right) {
      return new MyTreeNode(1);
    }
    MyTreeNode node = new MyTreeNode();
    int mid = (left+right)>>1;
    node.left = buildTree(left, mid);
    node.right = buildTree(mid+1, right);
    node.all = node.left.all+node.right.all;
    return node;
  }

  private int getRightIndex1(int[] nums, int val) {
    for (int i = nums.length-1; i >= 0; i--) {
      if (nums[i] == val) {
        return i;
      }
    }
    return -1;
  }

  private int getLeftIndex1(int[] nums, int val) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val) {
        return i;
      }
    }
    return -1;
  }

  private int getRightIndex(int[] nums, int val) {
    int left = 0;
    int right = nums.length-1;
    while (left < right) {
      int mid = (left+right+1)>>1;
      if (val >= nums[mid]) {
        left = mid;
      } else {
        right = mid-1;
      }
    }
    return left;
  }

  private int getLeftIndex(int[] nums, int val) {
    int left = 0;
    int right = nums.length-1;
    while (left < right) {
      int mid = (left+right)/2;
      if (val <= nums[mid]) {
        right = mid;
      } else {
        left = mid+1;
      }
    }
    return left;
  }
  private void addToList(TreeNode root, List<TreeNode> list) {
    if (root == null) {
      return;
    }
    addToList(root.left, list);
    list.add(root);
    addToList(root.right, list);
  }
}
