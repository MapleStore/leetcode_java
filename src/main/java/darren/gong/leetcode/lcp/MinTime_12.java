package darren.gong.leetcode.lcp;

public class MinTime_12 {
  public int minTime(int[] time, int m) {
    int avgNum = time.length/m+1;
    int maxTime = Integer.MIN_VALUE;
    for (int oneTime : time) {
      maxTime = Math.max(maxTime, oneTime);
    }
    int right = avgNum*maxTime;
    int left = 0;
    while (left <= right) {
      int mid = left+((right-left)>>>1);
      if (canOver(time, mid, m)) {
        right = mid-1;
      } else {
        left = mid+1;
      }
    }
    return right+1;
  }

  private boolean canOver(int[] time, int timeEachDay, int days) {
    int index = 0;
    int timeSum = 0;
    int needDay = 0;
    int maxTime = 0;
    while (index < time.length) {
      timeSum += time[index];
      maxTime = Math.max(maxTime, time[index]);
      if (timeSum - maxTime <= timeEachDay) {
        index++;
      } else {
        needDay++;
        maxTime = 0;
        timeSum = 0;
      }
      if (needDay >= days) {
        return false;
      }
    }
    return true;
  }
}
