package darren.gong.leetcode;

import java.util.Stack;

public class MinRemoveToMakeValid_1249 {
  // 1249. 移除无效的括号
  public String minRemoveToMakeValid(String s) {
    char[] arr = s.toCharArray();
    int length = arr.length;
    boolean[] delete = new boolean[length];
    Stack<Integer> indexCurrent = new Stack<>();
    for (int i = 0; i < length; i++) {
      if (arr[i] == '(') {
        indexCurrent.push(i);
      }
      if (arr[i] == ')') {
        if (!indexCurrent.isEmpty()) {
          indexCurrent.pop();
        } else {
          delete[i] = true;
        }
      }
    }
    while (!indexCurrent.isEmpty()) {
      delete[indexCurrent.pop()] = true;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      if (!delete[i]) {
        sb.append(arr[i]);
      }
    }
    return sb.toString();
  }
}
