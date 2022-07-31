package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReadBinaryWatch401 {
  private static ArrayList<Integer>[] hourMap = new ArrayList[5];
  private static ArrayList<Integer>[] minMap = new ArrayList[7];
  static {
    for (int i = 0; i <= 4; i++) {
      ArrayList<Integer> result = new ArrayList<>();
      dfs(new int[]{8,4,2,1}, 0, 0, i, 12, result);
      hourMap[i] = result;
    }
    for (int i = 0; i <= 6; i++) {
      ArrayList<Integer> result = new ArrayList<>();
      dfs(new int[]{32,16,8,4,2,1}, 0, 0, i, 60, result);
      minMap[i] = result;
    }

  }
  public List<String> readBinaryWatch(int num) {
    List<String> result = new LinkedList<>();
    for (int hourIndex = 0; hourIndex <= num && hourIndex <= 4; hourIndex++) {
      for (Integer hour : hourMap[hourIndex]) {
        if (num-hourIndex >= 7) {
          continue;
        }
        List<Integer> minutes = minMap[num-hourIndex];
        for (Integer minute : minMap[num-hourIndex]) {
          result.add(hour+":"+(minute < 10 ? "0"+minute : minute));
        }
      }
    }
    return result;
  }

  private static void dfs(int[] times, int currentTime, int index, int toBeAdd, int limit, List<Integer> result) {
    if (currentTime >= limit) {
      return;
    }
    if (toBeAdd == 0) {
      result.add(currentTime);
      return;
    }
    for (int i = index; i < times.length; i++) {
      dfs(times, currentTime+times[i], i+1, toBeAdd-1, limit, result);
    }
  }

}
