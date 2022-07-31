package darren.gong.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Leaderboard_1244 {
  // 1244. 力扣排行榜
  public static void main(String[] args) {
    Leaderboard_1244 leaderboard_1244 = new Leaderboard_1244();
    leaderboard_1244.addScore(1, 73);
    leaderboard_1244.addScore(2, 56);
    leaderboard_1244.addScore(3, 39);
    leaderboard_1244.addScore(4, 51);
    leaderboard_1244.addScore(5, 4);
    leaderboard_1244.reset(1);
    leaderboard_1244.reset(2);
    leaderboard_1244.addScore(2, 51);
    leaderboard_1244.top(3);
  }
  // playerId对应分数
  private int[] scores = new int[10001];
  // 分数及对应人数
  private TreeMap<Integer, Integer> treeMap = new TreeMap<>((a,b)->b-a);
  public Leaderboard_1244() {

  }

  public void addScore(int playerId, int score) {
    if (scores[playerId] != 0) {
      treeMap.put(scores[playerId], treeMap.get(scores[playerId])-1);
    }
    scores[playerId] += score;
    treeMap.put(scores[playerId], treeMap.getOrDefault(scores[playerId], 0)+1);
    return;
  }

  public int top(int K) {
    int result = 0;
    for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
      if (K <= 0) {
        break;
      }
      int score = entry.getKey();
      int num = Math.min(K, entry.getValue());
      result += score*num;
      K -= num;
    }
    return result;
  }

  public void reset(int playerId) {
    treeMap.put(scores[playerId], treeMap.get(scores[playerId])-1);
    scores[playerId] = 0;
    return;
  }
}
