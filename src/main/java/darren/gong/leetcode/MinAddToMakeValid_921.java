package darren.gong.leetcode;

import java.util.Stack;

public class MinAddToMakeValid_921 {
  // 921. 使括号有效的最少添加
  public int minAddToMakeValid(String S) {
    int left = 0;
    int right = 0;
    int length = S.length();
    for (int i = 0; i < length; i++) {
      if (S.charAt(i) == '(') {
        left++;
      } else {
        if (left > 0) {
          left--;
        } else {
          right++;
        }
      }
    }
    return left+right;
  }
}
