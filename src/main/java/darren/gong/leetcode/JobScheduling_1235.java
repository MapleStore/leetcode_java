package darren.gong.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

public class JobScheduling_1235 {
  public static void main(String[] args) {
    JobScheduling_1235 jobScheduling_1235 = new JobScheduling_1235();
    jobScheduling_1235.jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70});
  }
  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int length = startTime.length;
    int[][] jobs = new int[length][];
    for (int i = 0; i < length; i++) {
      jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
    }
    Arrays.sort(jobs, (a,b)->a[1]-b[1]);
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < length; i++) {
      map.put(jobs[i][1], i);
    }
    int[] dp = new int[length+1];
    for (int i = 1; i <= length; i++) {
      // 当前包含
      int[] job = jobs[i-1];
      dp[i] = job[2];
      Integer key = map.floorKey(job[0]);
      if (key != null) {
        dp[i] += dp[map.get(key)+1];
      }

      // 当前不包含
      dp[i] = Math.max(dp[i-1], dp[i]);
    }
    return dp[length];
  }
}
