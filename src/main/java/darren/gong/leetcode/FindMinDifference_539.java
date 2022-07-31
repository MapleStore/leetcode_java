package darren.gong.leetcode;

import java.util.Arrays;
import java.util.List;

public class FindMinDifference_539 {
  public int findMinDifference(List<String> timePoints) {
    int length = timePoints.size();
    int[] minutes = new int[length];
    int index = 0;
    for (String timePoint : timePoints) {
      String[] val = timePoint.split(":");
      minutes[index++] = Integer.parseInt(val[0])*60+Integer.parseInt(val[1]);
    }
    Arrays.sort(minutes);
    int result = Integer.MAX_VALUE;
    for (int i = 1; i < length; i++) {
      result = Math.min(minutes[i]-minutes[i-1], result);
    }
    result = Math.min(result, minutes[0]+24*60-minutes[length-1]);
    return result;
  }
}
