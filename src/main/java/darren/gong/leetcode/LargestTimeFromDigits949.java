package darren.gong.leetcode;

import java.util.Arrays;

public class LargestTimeFromDigits949 {
  public static void main(String[] args) {
    LargestTimeFromDigits949 largestTimeFromDigits949 = new LargestTimeFromDigits949();
    largestTimeFromDigits949.largestTimeFromDigits(new int[]{2,1,1,0});
  }
  private int[] result = new int[4];
  private boolean find = false;
  public String largestTimeFromDigits(int[] arr) {
    Arrays.sort(arr);
    dfs(0, new boolean[4], arr, new int[4], false);
    if (find) {
      return new StringBuilder().append(result[0]).append(result[1]).append(':').append(result[2]).append(result[3]).toString();
    }
    return "";
  }
  private void dfs(int index, boolean[] visited, int[] arr, int[] currentTime, boolean bigger) {
    if (index == 4) {
      if (isValidTime(currentTime)) {
        find = true;
        result = new int[4];
        for (int i = 0; i < 4; i++) {
          result[i] = currentTime[i];
        }
      }
      return;
    }
    for (int i = 0; i < 4; i++) {
      // 之前大于或当前大于等于
      if (!visited[i] && (bigger || result[index] <= arr[i])) {
        visited[i] = true;
        currentTime[index] = arr[i];
        // 之前大于或当前大于, 之前如果小于, 走不到这里
        dfs(index+1, visited, arr, currentTime, bigger || result[index] < arr[i]);
        visited[i] = false;
      }
    }
    return;
  }
  private boolean isValidTime(int[] currentTime) {
    int hour = currentTime[0]*10+currentTime[1];
    int min = currentTime[2]*10+currentTime[3];
    if (hour >= 24 || min >= 60) {
      return false;
    }
    return true;
  }
}
