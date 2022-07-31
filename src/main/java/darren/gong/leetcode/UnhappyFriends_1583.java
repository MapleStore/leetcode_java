package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UnhappyFriends_1583 {
  // 1583. 统计不开心的朋友
  public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
    int[][] newPreference = new int[n][n];
    for (int i = 0; i < n; i++) {
      int[] preference = preferences[i];
      for (int j = 0; j < n-1; j++) {
        newPreference[i][preference[j]] = j;
      }
    }
    Map<Integer, Integer> newPairs = new HashMap<>();
    for (int[] pair : pairs) {
      newPairs.put(pair[0], pair[1]);
      newPairs.put(pair[1], pair[0]);
    }
    int result = 0;
    for (int[] pair : pairs) {
      int sweet = newPreference[pair[0]][pair[1]];
      for (int i = 0; i < sweet; i++) {
        int moreLikePeople = preferences[pair[0]][i];
        if (newPreference[moreLikePeople][pair[0]] < newPreference[moreLikePeople][newPairs.get(moreLikePeople)]) {
          result++;
          break;
        }
      }

      sweet = newPreference[pair[1]][pair[0]];
      for (int i = 0; i < sweet; i++) {
        int moreLikePeople = preferences[pair[1]][i];
        if (newPreference[moreLikePeople][pair[1]] < newPreference[moreLikePeople][newPairs.get(moreLikePeople)]) {
          result++;
          break;
        }
      }
    }
    return result;
  }
}
