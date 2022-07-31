package darren.gong.leetcode.offer;

public class IsSubStructure_26 {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public boolean isSubStructure(TreeNode A, TreeNode B) {
    if (A == null || B == null) {
      return false;
    }
    if (A.val == B.val && isSubStructureHelper(A, B)) {
      return true;
    }
    return isSubStructure(A.left, B) || isSubStructure(A.right, B);
  }
  public boolean isSubStructureHelper(TreeNode A, TreeNode B) {
    if (B == null) {
      return true;
    }
    if (A == null) {
      return false;
    }
    if (A.val != B.val) {
      return false;
    }
    return isSubStructureHelper(A.left, B.left) && isSubStructureHelper(A.right, B.right);
  }
}
