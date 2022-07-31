package darren.gong.leetcode;

import java.util.Stack;

public class EvalRPN {
    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        evalRPN.evalRPN(new String[]{"4","13","5","/","+"});
    }
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length <= 0) {
            return -1;
        }
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (token.equals("/")) {
                int num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
