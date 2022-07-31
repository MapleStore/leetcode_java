package darren.gong.leetcode;

import java.util.Arrays;

public class BestTeamScore_1626 {
  public static void main(String[] args) {
    BestTeamScore_1626 bestTeamScore_1626 = new BestTeamScore_1626();
    bestTeamScore_1626.bestTeamScore(new int[]{1,2,3,5}, new int[]{8,9,10,1});
  }
  public int bestTeamScore(int[] scores, int[] ages) {
    int length = scores.length;
    int[][] people = new int[length][];
    for (int i = 0; i < length; i++) {
      people[i] = new int[]{ages[i], scores[i]};
    }
    Arrays.sort(people, (a,b)->{
      if (a[0] == b[0]) {
        return a[1]-b[1];
      } else {
        return a[0]-b[0];
      }
    });
    int[] dp = new int[length];
    dp[0] = people[0][1];
    for (int i = 1; i < length; i++) {
      int currentAge = people[i][0];
      int currentScore = people[i][1];
      int value = currentScore;
      for (int j = i-1; j >= 0; j--) {
        int[] prePeople = people[j];
        int preAge = prePeople[0];
        int preScore = prePeople[1];
        // 年龄相同 或 年龄小但分数小
        if (preAge == currentAge || preScore <= currentScore) {
          value = Math.max(value, dp[j]+currentScore);
        }
      }
      dp[i] = value;
    }
    int result = Integer.MIN_VALUE;
    for (int value : dp) {
      result = Math.max(result, value);
    }
    return result;
  }
}
