package darren.gong.leetcode;

import java.util.PriorityQueue;

public class RankTeams_1366 {
  public static void main(String[] args) {
    RankTeams_1366 rankTeams_1366 = new RankTeams_1366();
    rankTeams_1366.rankTeams(new String[]{"BCA","CAB","CBA","ABC","ACB","BAC"});
  }
  public String rankTeams(String[] votes) {
    final int length = votes[0].length();
    int[][] scores = new int[26][length+1];
    for (int i = 0; i < 26; i++) {
      scores[i][length] = i;
    }
    for (String vote : votes) {
      int pos = 0;
      for (char team : vote.toCharArray()) {
        scores[team-'A'][pos]++;
        pos++;
      }
    }

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->{
      for (int i = 0; i < length; i++) {
        if (a[i] != b[i]) {
          return b[i]-a[i];
        }
      }
      return a[length]-b[length];
    });
    for (int i = 0; i < 26; i++) {
      priorityQueue.add(scores[i]);
    }
    StringBuilder result = new StringBuilder();
    int count = 0;
    while (count++ < length) {
      result.append((char)('A'+priorityQueue.poll()[length]));
    }
    return result.toString();
  }
}
