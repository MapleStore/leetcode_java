package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Jump45 {
  // 贪心
  public int jump(int[] nums) {
    if (nums == null) {
      return -1;
    }
    int length = nums.length;
    if (length <= 1) {
      return 0;
    }
    int end = nums[0];
    int start = 1;
    int result = 1;
    while (end < length-1) {
      int tempEnd = end;
      for (; start <= tempEnd; start++) {
        end = Math.max(end, start+nums[start]);
      }
      result++;
    }
    return result;
  }

  public int jumpDP(int[] nums) {
    if (nums == null) {
      return -1;
    }
    int length = nums.length;
    if (length <= 1) {
      return 0;
    }
    int[] dp = new int[length];
    for (int i = 1; i < length; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    dp[0] = 0;
    for (int i = 0; i < length; i++) {
      if (i+nums[i] >= length-1) {
        return dp[i]+1;
      }
      for (int j = i+1; j <= i+nums[i]; j++) {
        dp[j] = Math.min(dp[i]+1, dp[j]);
      }
    }
    return dp[length-1];
  }


  public int jumpBFS(int[] nums) {
    if (nums == null) {
      return -1;
    }
    int length = nums.length;
    if (length <= 1) {
      return 0;
    }
    boolean[] visited = new boolean[length];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    int result = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int index = queue.poll();
        int distance = nums[index];
        if (index+distance >= length-1) {
          return result;
        }
        for (int i = 1; i <= distance; i++) {
          int nextIndex = index+i;
          if (nextIndex < length && !visited[nextIndex]) {
            queue.add(nextIndex);
            visited[nextIndex] = true;
          }
        }
      }
      result++;
    }
    return -1;
  }
}
