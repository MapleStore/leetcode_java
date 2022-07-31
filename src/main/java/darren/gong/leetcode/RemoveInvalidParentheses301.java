package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses301 {
  public static void main(String[] args) {
    RemoveInvalidParentheses301 removeInvalidParentheses301 = new RemoveInvalidParentheses301();
    removeInvalidParentheses301.removeInvalidParentheses("()())()");
  }
  public List<String> removeInvalidParentheses(String s) {
    Set<String> result = new HashSet<>();
    if (s == null) {
      return new ArrayList<>(result);
    }
    if (s.length() == 0) {
      result.add("");
      return new ArrayList<>(result);
    }
    char[] charArr = s.toCharArray();
    int left = 0;
    int right = 0;
    for (char one : charArr) {
      if (one == '(') {
        left++;
      }
      if (one == ')') {
        if (left > 0) {
          left--;
        } else {
          right++;
        }
      }
    }
    dfs(charArr, 0, new StringBuilder(), left, right, result);
    return new ArrayList<>(result);
  }
  private void dfs(char[] charArr, int index, StringBuilder oneResult, int left, int right, Set<String> result) {
    if (left < 0 || right < 0) {
      return;
    }
    if (index == charArr.length) {
      if (left == 0 && right == 0 && parenthesesValid(oneResult)) {
        result.add(oneResult.toString());
      }
      return;
    }

    dfs(charArr, index+1, oneResult.append(charArr[index]), left, right, result);
    oneResult.deleteCharAt(oneResult.length()-1);

    if (charArr[index] == '(') {
      dfs(charArr, index+1, oneResult, left-1, right, result);
    } else if (charArr[index] == ')') {
      dfs(charArr, index+1, oneResult, left, right-1, result);
    }
  }
  private boolean parenthesesValid(StringBuilder s) {
    int left = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        left++;
      }
      if (s.charAt(i) == ')') {
        if (left > 0) {
          left--;
        } else {
          return false;
        }
      }
    }
    return left == 0;
  }
}
