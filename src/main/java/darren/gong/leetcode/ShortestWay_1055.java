package darren.gong.leetcode;

import java.util.Arrays;

public class ShortestWay_1055 {
  public static void main(String[] args) {
    ShortestWay_1055 shortestWay_1055 = new ShortestWay_1055();
    shortestWay_1055.shortestWay("abc", "abcbc");
  }
  public int shortestWay(String source, String target) {
    int[][] allNext = new int[source.length()][];
    int[] next = new int[26];
    Arrays.fill(next, -1);

    for (int i = source.length()-1; i >= 0; i--) {
      allNext[i] = copy(next);
      char currentChar = source.charAt(i);
      next[currentChar-'a'] = i;
    }
    for (int i = source.length()-1; i >= 0; i--) {
      allNext[i] = copy(next);
      char currentChar = source.charAt(i);
      next[currentChar-'a'] = i;
    }

    int currentIndex = allNext[source.length()-1][target.charAt(0)-'a'];
    int result = 1;
    for (int i = 1; i < target.length(); i++) {
      char oneChar = target.charAt(i);
      int nextIndex = allNext[currentIndex][oneChar-'a'];
      if (nextIndex == -1) {
        return -1;
      }
      if (nextIndex <= currentIndex) {
        result++;
      }
      currentIndex = nextIndex;
    }
    return result;
  }
  private int[] copy(int[] val) {
    return Arrays.copyOf(val, val.length);
  }
}
