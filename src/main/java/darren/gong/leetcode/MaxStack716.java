package darren.gong.leetcode;

import java.util.PriorityQueue;
import java.util.Stack;

public class MaxStack716 {
  private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);
  private Stack<Integer> stack = new Stack<>();
  /** initialize your data structure here. */
  public MaxStack716() {

  }

  public void push(int x) {
    priorityQueue.add(x);
    stack.push(x);
  }

  public int pop() {
    int num = stack.pop();
    priorityQueue.remove(num);
    return num;
  }

  public int top() {
    return stack.peek();
  }

  public int peekMax() {
    return priorityQueue.peek();
  }

  public int popMax() {
    int num = priorityQueue.poll();
    stack.remove(stack.lastIndexOf(num));
    return num;
  }

}
