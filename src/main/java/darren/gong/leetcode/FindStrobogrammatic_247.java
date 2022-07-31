package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindStrobogrammatic_247 {
  private int[] map = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
  private List<String> tempResult = new ArrayList<>();
  public List<String> findStrobogrammatic(int n) {
    if (n == 0) {
      return tempResult;
    }
    findStrobogrammaticHelper(n/2, new StringBuilder());
    List<String> result = new ArrayList<>(tempResult.size());
    if (n%2 == 0) {
      for (String tempString : tempResult) {
        StringBuilder sb = new StringBuilder(tempString);
        String half = getLastHalf(sb);
        result.add(sb.append(half).toString());
      }
    } else {
      for (String tempString : tempResult) {
        StringBuilder sb = new StringBuilder(tempString);
        String half = getLastHalf(sb);
        for (int i = 0; i < 10; i++) {
          if (map[i] == i) {
            result.add(new StringBuilder().append(sb).append(i).append(half).toString());
          }
        }
      }
    }
    return result;
  }
  private String getLastHalf(StringBuilder sb) {
    StringBuilder result = new StringBuilder();
    int index = sb.length()-1;
    while (index >= 0) {
      result.append(map[sb.charAt(index)-'0']);
      index--;
    }
    return result.toString();
  }
  private void findStrobogrammaticHelper(int n, StringBuilder sb) {
    if (n == 0) {
      tempResult.add(sb.toString());
      return;
    }
    for (int i = 0; i < 10; i++) {
      if (map[i] == -1) {
        continue;
      }
      if (sb.length() == 0 && i == 0) {
        continue;
      }
      sb.append(i);
      findStrobogrammaticHelper(n-1, sb);
      sb.deleteCharAt(sb.length()-1);
    }
  }
}
