package darren.gong.leetcode;

import java.util.List;
import java.util.Stack;

public class ExclusiveTime636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();
        int lastTime = -1;
        for (String log : logs) {
            String[] processLog = log.split(":");
            if (processLog[1].equals("start")) {
                int startTime = Integer.valueOf(processLog[2]);
                if (!stack.isEmpty()) {
                    int[] startLog = stack.peek();
                    result[startLog[0]] += startTime - lastTime;
                }
                stack.push(new int[]{Integer.valueOf(processLog[0]), startTime});
                lastTime = startTime;
            } else {
                int endTime = Integer.valueOf(processLog[2]);
                int[] startLog = stack.pop();
                result[startLog[0]] += endTime - lastTime + 1;
                lastTime = endTime+1;
            }
        }
        return result;
    }
}
