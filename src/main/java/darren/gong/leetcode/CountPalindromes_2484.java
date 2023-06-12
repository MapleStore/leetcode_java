package darren.gong.leetcode;

import java.util.Arrays;

public class CountPalindromes_2484 {
  public static void main(String[] args) {
    CountPalindromes_2484 countPalindromes_2484 = new CountPalindromes_2484();
    countPalindromes_2484.countPalindromes("103301");
  }
  int[][] pres;
  int[][] nexts;
  public int countPalindromes(String s) {
    int length = s.length();
    int[] pre = new int[10];
    Arrays.fill(pre, -1);
    pres = new int[length][];
    for (int i = 0; i < length; i++) {
      pre[s.charAt(i)-'0'] = i;
      pres[i] = Arrays.copyOf(pre, 10);
    }
    int[] next = new int[10];
    Arrays.fill(next, length);
    nexts = new int[length][];
    for (int i = length-1; i >= 0; i--) {
      next[s.charAt(i)-'0'] = i;
      nexts[i] = Arrays.copyOf(next, 10);
    }
    return countPalindromes(0, length-1, 5);
  }
  private int countPalindromes(int start, int end, int count) {
    if (start > end) {
      return 0;
    }
    int result = 0;
    if (count == 1) {
      for (int i = 0; i < 10; i++) {
        if (nexts[start][i] <= end) result++;
      }
      return result;
    }
    for (int i = 0; i < 10; i++) {
      int nextStart = nexts[start][i];
      int nextEnd = pres[end][i];
      result += countPalindromes(nextStart+1, nextEnd-1, count-2);
    }
    return result;
  }
}
