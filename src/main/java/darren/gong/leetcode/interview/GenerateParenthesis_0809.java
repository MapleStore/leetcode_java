package darren.gong.leetcode.interview;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis_0809 {
  private List<String> result = new LinkedList<>();
  private int n;
  public List<String> generateParenthesis(int n) {
    backTracking(n, 0, new StringBuilder());
    return result;
  }
  private void backTracking(int leftNeed, int rightNeed, StringBuilder sb) {
    if (leftNeed == 0 && rightNeed == 0) {
      result.add(sb.toString());
      return;
    }
    if (leftNeed > 0) {
      sb.append('(');
      backTracking(leftNeed-1, rightNeed+1, sb);
      sb.deleteCharAt(sb.length()-1);
    }
    if (rightNeed > 0) {
      sb.append(')');
      backTracking(leftNeed, rightNeed-1, sb);
      sb.deleteCharAt(sb.length()-1);
    }
    return;
  }
}
