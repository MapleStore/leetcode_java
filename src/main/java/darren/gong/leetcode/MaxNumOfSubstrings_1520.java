package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNumOfSubstrings_1520 {
  public static void main(String[] args) {
    MaxNumOfSubstrings_1520 maxNumOfSubstrings_1520 = new MaxNumOfSubstrings_1520();
    maxNumOfSubstrings_1520.maxNumOfSubstrings("adefaddaccc");
  }
  private List<int[]> result = new ArrayList<>();
  private int length = 0;
  public List<String> maxNumOfSubstrings(String s) {
    int length = s.length();
    int[][] positions = new int[26][2];
    for (int[] position : positions) {
      Arrays.fill(position, -1);
    }
    for (int i = 0; i < length; i++) {
      int current = s.charAt(i)-'a';
      if (positions[current][0] == -1) {
        positions[current][0] = i;
      }
    }
    for (int i = length-1; i >= 0; i--) {
      int current = s.charAt(i)-'a';
      if (positions[current][1] == -1) {
        positions[current][1] = i;
      }
    }

    int[][] ranges = new int[26][2];
    for (int i = 0; i < 26; i++) {
      ranges[i] = getRange(s, positions, i);
    }

    Arrays.sort(ranges, (a,b)->a[0]-b[0]);
    int index = 0;
    while (ranges[index][0] == -1) index++;
    dfs(ranges, index, new ArrayList<>());
    List<String> returnResult = new ArrayList<>();
    for (int[] one : result) {
      returnResult.add(s.substring(one[0], one[1]+1));
    }
    return returnResult;
  }

  private void dfs(int[][] positions, int start, List<int[]> oneResult) {
    if (start == 26) {
      if (oneResult.size() > result.size()) {
        result = new ArrayList<>(oneResult);
      } else if (oneResult.size() == result.size()) {
        int countLength = countLength(oneResult);
        if (countLength < length) {
          length = countLength;
          result = new ArrayList<>(oneResult);
        }
      }
      return;
    }
    for (int i = start; i < 26; i++) {
      int[] current = positions[i];
      int[] pre = oneResult.size() == 0 ? new int[] {-1,-1} : oneResult.get(oneResult.size()-1);
      if (current[0] <= pre[1]) {
        continue;
      }

      boolean best = true;
      for (int j = i+1; j < 26; j++) {
        if (positions[j][1] < positions[i][1]) {
          best = false;
          break;
        }
      }
      if (!best) {
        continue;
      }
      oneResult.add(current);
      dfs(positions, i+1, oneResult);
      oneResult.remove(oneResult.size()-1);
    }
  }
  private int[] getRange(String s, int[][] positions, int index) {
    if (positions[index][0] == -1 && positions[index][1] == -1) {
      return positions[index];
    }
    int left = positions[index][0];
    int right = positions[index][0];
    int min = positions[index][0];
    int max = positions[index][1];
    while (left != min || right != max) {
      while (left > min) {
        int current = s.charAt(left)-'a';
        min = Math.min(positions[current][0], min);
        max = Math.max(positions[current][1], max);
        left--;
      }
      while (right < max) {
        int current = s.charAt(right)-'a';
        min = Math.min(positions[current][0], min);
        max = Math.max(positions[current][1], max);
        right++;
      }
    }
    return new int[]{min, max};
  }
  private int countLength(List<int[]> newResult) {
    int result = 0;
    for (int[] one : newResult) {
      result += one[1]-one[0]+1;
    }
    return result;
  }
}
