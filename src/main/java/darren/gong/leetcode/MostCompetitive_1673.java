package darren.gong.leetcode;

import java.util.Stack;

public class MostCompetitive_1673 {
  public static void main(String[] args) {
    MostCompetitive_1673 mostCompetitive_1673 = new MostCompetitive_1673();
    mostCompetitive_1673.mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 2);
  }
  public int[] mostCompetitive(int[] nums, int k) {
    int length = nums.length;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < length; i++) {
      int restNum = length-1-i;
      int num = nums[i];
      while (!stack.isEmpty() && num < stack.peek() && stack.size()+restNum >= k) {
        stack.pop();
      }
      stack.push(num);
    }
    int[] result = new int[k];
    while (stack.size() > k) {
      stack.pop();
    }
    while (--k >= 0) {
      result[k] = stack.pop();
    }
    return result;
  }
}
