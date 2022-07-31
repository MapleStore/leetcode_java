package darren.gong.leetcode;

import java.util.Stack;

public class StockSpanner901 {
  private Stack<int[]> stack = new Stack<>();
  private int index = 1;
  public StockSpanner901() {
    stack.push(new int[]{0, Integer.MAX_VALUE});
  }

  public int next(int price) {
     while (!stack.isEmpty() && stack.peek()[1] <= price) {
       stack.pop();
     }
     int[] pre = stack.peek();
     stack.push(new int[]{index++, price});
     return index-pre[0]-1;
  }
}
