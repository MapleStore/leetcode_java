package darren.gong.leetcode;

public class Tree2str606 {
  public String tree2str(TreeNode t) {
    if (t == null) {
      return "";
    }
    StringBuilder result = new StringBuilder();
    tree2strHelper(t, result);
    return result.toString();
  }
  private void tree2strHelper(TreeNode t, StringBuilder result) {
    if (t == null) {
      return;
    }
    result.append(t.val);
    if (t.left != null || t.right != null) {
      result.append('(');
      tree2strHelper(t.left, result);
      result.append(')');
    }
    if (t.right != null) {
      result.append('(');
      tree2strHelper(t.right, result);
      result.append(')');
    }
    return;
  }
}
