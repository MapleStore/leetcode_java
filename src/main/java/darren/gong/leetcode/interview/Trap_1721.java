package darren.gong.leetcode.interview;

import java.util.Stack;

public class Trap_1721 {
  public static void main(String[] args) {
    Trap_1721 trap_1721 = new Trap_1721();
    trap_1721.trap(new int[]{3,0,2,0,1});
  }
  public int trap(int[] height) {
    Stack<int[]> stack = new Stack<>();
    int length = height.length;
    int result = 0;
    for (int i = 0; i < length; i++) {
      int current = height[i];
      int maxHeight = 0;
      while (!stack.isEmpty() && stack.peek()[1] <= current) {
        int[] pre = stack.pop();
        result += (pre[1]-maxHeight)*(i-pre[0]-1);
        maxHeight = Math.max(maxHeight, pre[1]);
      }
      if (!stack.isEmpty()) {
        result += (current-maxHeight)*(i-stack.peek()[0]-1);
      }
      stack.push(new int[]{i, current});
    }
    return result;
  }
}
