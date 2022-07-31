package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class StoneGame_877 {
  private Map<Integer, Integer> remember = new HashMap<>();
  // 877. 石子游戏
  public boolean stoneGame(int[] piles) {
    int length = piles.length;
    int result = Math.max(piles[0]-stoneGameHelper(piles, 1, length-1), piles[length-1]-stoneGameHelper(piles, 0, length-2));
    return result > 0;
  }
  public int stoneGameHelper(int[] piles, int start, int end) {
    if (start == end) {
      return piles[start];
    }
    int index = start*1000+end;
    if (remember.containsKey(index)) {
      return remember.get(index);
    }
    int value = Math.max(piles[start]-stoneGameHelper(piles, start+1, end), piles[end]-stoneGameHelper(piles, start, end-1));
    remember.put(index, value);
    return value;
  }
}
