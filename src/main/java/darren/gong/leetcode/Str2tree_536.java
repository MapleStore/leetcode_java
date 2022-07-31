package darren.gong.leetcode;

public class Str2tree_536 {
  // 536. 从字符串生成二叉树
  private int index = 0;
  public TreeNode str2tree(String s) {
    if (index >= s.length()) {
      return null;
    }
    if (s.charAt(index) == '(') {
      index++;
    }
    char current;
    StringBuilder sb = new StringBuilder();
    while (index < s.length() && (current = s.charAt(index)) != '(' && current != ')') {
      sb.append(current);
      index++;
    }
    TreeNode node = sb.length() == 0 ? null : new TreeNode(Integer.parseInt(sb.toString()));
    if (node != null) {
      if (index < s.length() && s.charAt(index) == '(') {
        node.left = str2tree(s);
      }
      if (index < s.length() && s.charAt(index) == '(') {
        node.right = str2tree(s);
      }
    }
    if (index < s.length() && s.charAt(index) == ')') {
      index++;
    }
    return node;
  }
}
