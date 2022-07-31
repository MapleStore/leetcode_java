package darren.gong.leetcode;

import java.util.Arrays;
import java.util.TreeSet;

public class NextClosestTime681 {
  public String nextClosestTime(String time) {
    char[] timeArr = time.toCharArray();
    TreeSet<Integer> set = new TreeSet<>();
    int[] originTime = new int[4];
    int index = 0;
    for (int i = 0; i < 5; i++) {
      if (timeArr[i] == ':') {
        continue;
      }
      originTime[index] = timeArr[i]-'0';
      set.add(originTime[index]);
      index++;
    }

    for (int i = 3; i >= 0; i--) {
      Integer value = set.ceiling(originTime[i]+1);
      if (value == null) {
        continue;
      }
      if (timeValid(originTime, i, value)) {
        originTime[i] = value;
        for (int j = 3; j > i; j--) {
          originTime[j] = set.first();
        }
        return "" + originTime[0] + originTime[1] + ':' + originTime[2] + originTime[3];
      }
    }
    int min = set.first();
    return "" + min + min + ':' + min + min;
  }

  private boolean timeValid(int[] originTime, int index, int value) {
    int[] temp = Arrays.copyOf(originTime, 4);
    temp[index] = value;
    int hour = temp[0]*10+temp[1];
    int min = temp[2]*10+temp[3];
    if (hour >= 0 && hour <= 23 && min >= 0 && min <= 59) {
      return true;
    }
    return false;
  }
}
