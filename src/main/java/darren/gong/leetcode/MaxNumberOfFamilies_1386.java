package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfFamilies_1386 {
  // 1386. 安排电影院座位
  public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    Map<Integer, boolean[]> map = new HashMap<>();
    for (int[] reservedSeat : reservedSeats) {
      boolean[] line = map.get(reservedSeat[0]);
      if (line == null) {
        line = new boolean[11];
        map.put(reservedSeat[0], line);
      }
      line[reservedSeat[1]] = true;
    }
    int result = 2*(n-map.size());
    for (boolean[] seat : map.values()) {
      if (!seat[2]&&!seat[3]&&!seat[4]&&!seat[5]) {
        result++;
        seat[2]=seat[3]=seat[4]=seat[5] = true;
      }
      if (!seat[4]&&!seat[5]&&!seat[6]&&!seat[7]) {
        result++;
        seat[4]=seat[5]=seat[6]=seat[7] = true;
      }
      if (!seat[6]&&!seat[7]&&!seat[8]&&!seat[9]) {
        result++;
        seat[6]=seat[7]=seat[8]=seat[9] = true;
      }
    }
    return result;
  }
}
