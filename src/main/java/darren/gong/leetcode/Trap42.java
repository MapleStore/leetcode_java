package darren.gong.leetcode;

import java.util.Stack;

public class Trap42 {
    public static void main(String[] args) {
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            if (stack.size() == 0 || height[i] < stack.peek()[1]) {
                stack.push(new int[]{i, height[i]});
                continue;
            }
            int max = stack.pop()[1];
            while (stack.size() > 0) {
                int[] pre2 = stack.peek();
                result += (Math.min(height[i], pre2[1]) - max) * (i - pre2[0] - 1);
                max = pre2[1];
                if (max > height[i]) {
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(new int[]{i, height[i]});
        }
        return result;
    }
}
