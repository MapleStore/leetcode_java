package darren.gong.leetcode;

import java.util.Arrays;

public class Makesquare_473 {
  // 473. 火柴拼正方形
  public static void main(String[] args) {
    Makesquare_473 makesquare_473 = new Makesquare_473();
    makesquare_473.makesquare(new int[]{5,5,5,5,16,4,4,4,4,4,3,3,3,3,4});
  }
  private int each;
  private int length;
  public boolean makesquare(int[] matchsticks) {
    Arrays.sort(matchsticks);
    this.length = matchsticks.length;
    int sum = 0;
    for (int value : matchsticks) {
      sum += value;
    }
    if (sum%4 != 0) {
      return false;
    }
    this.each = sum/4;
    if (each == 0) {
      return false;
    }
    return backTracking(new boolean[this.length], matchsticks, 0, this.each);
  }
  private boolean backTracking(boolean[] visited, int[] matchsticks, int startIndex, int need) {
    if (need == 0) {
      if (end(visited)) {
        return true;
      }
      return backTracking(visited, matchsticks, 0, each);
    }
    for (int i = startIndex; i < length; i++) {
      if (visited[i]) {
        continue;
      }
      if (i != 0 && matchsticks[i] == matchsticks[i-1] && !visited[i-1]) {
        continue;
      }
      if (matchsticks[i] > need) {
        break;
      }
      visited[i] = true;
      if (backTracking(visited, matchsticks, i+1, need-matchsticks[i])) {
        return true;
      }
      visited[i] = false;
    }
    return false;
  }
  private boolean end(boolean[] visited) {
    for (boolean oneVisited : visited) {
      if (!oneVisited) {
        return false;
      }
    }
    return true;
  }
}
