package darren.gong.leetcode;

public class ExpTree1597 {
  public static void main(String[] args) {
    ExpTree1597 expTree1597 = new ExpTree1597();
    Node node = expTree1597.expTree("(9*9-(9-7)*3)/(3*1)");
    return;
  }
  class Node {
    char val;
    Node left;
    Node right;
    Node() {this.val = ' ';}
    Node(char val) { this.val = val; }
    Node(char val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  public Node expTree(String s) {
    if (s == null || s.length() == 0) {
      return null;
    }
    if (s.length() == 1) {
      return new Node(s.charAt(0));
    }
    StringBuilder sb = new StringBuilder(s);
    trimBrackets(sb);
    int splitIndex = getLastAddOrDecIndex(sb);
    if (splitIndex != -1) {
      Node root = new Node(sb.charAt(splitIndex));
      root.left = expTree(sb.substring(0, splitIndex));
      root.right = expTree(sb.substring(splitIndex+1));
      return root;
    }
    splitIndex = getLastMultiplyOrDivideIndex(sb);
    if (splitIndex != -1) {
      Node root = new Node(sb.charAt(splitIndex));
      root.left = expTree(sb.substring(0, splitIndex));
      root.right = expTree(sb.substring(splitIndex+1));
      return root;
    }
    return null;
  }
  private int getLastAddOrDecIndex(StringBuilder sb) {
    int length = sb.length();
    int splitIndex;
    int inBrackets = 0;
    for (splitIndex = length-1; splitIndex >= 0; splitIndex--) {
      if (sb.charAt(splitIndex) == ')') inBrackets++;
      else if (sb.charAt(splitIndex) == '(') inBrackets--;
      else {
        char split = sb.charAt(splitIndex);
        if (inBrackets == 0 && (split == '+' || split == '-')) {
          return splitIndex;
        }
      }
    }
    return -1;
  }
  private int getLastMultiplyOrDivideIndex(StringBuilder sb) {
    int length = sb.length();
    int splitIndex;
    int inBrackets = 0;
    for (splitIndex = length-1; splitIndex >= 0; splitIndex--) {
      if (sb.charAt(splitIndex) == ')') inBrackets++;
      else if (sb.charAt(splitIndex) == '(') inBrackets--;
      else {
        char split = sb.charAt(splitIndex);
        if (inBrackets == 0 && (split == '*' || split == '/')) {
          return splitIndex;
        }
      }
    }
    return -1;
  }
  private void trimBrackets(StringBuilder sb) {
    int length = sb.length();
    int inBrackets = 0;
    if (sb.charAt(0) != '(' || sb.charAt(length-1) != ')') {
      return;
    }
    for (int i = 0; i < length; i++) {
      if (sb.charAt(i) == '(') inBrackets++;
      else if (sb.charAt(i) == ')') inBrackets--;

      if (inBrackets == 0 && i != length-1) {
        return;
      }
    }
    sb.deleteCharAt(sb.length() - 1);
    sb.deleteCharAt(0);
  }
}
