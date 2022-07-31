package darren.gong.leetcode.race;

import java.util.ArrayList;
import java.util.Arrays;

public class GetMaximumNumber {
  public int getMaximumNumber(int[][] moles) {
    int length = moles.length;
    Arrays.sort(moles, (a,b)->a[0]-b[0]);

    ArrayList<int[]>[][] remember = new ArrayList[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        remember[i][j] = new ArrayList<>();
      }
    }
    remember[1][1].add(new int[]{0, 0});
    int[] dp = new int[length];
    for (int i = 0; i < length; i++) {
      int[] mole = moles[i];
      for (int x = 0; x < 3; x++) {
        for (int y = 0; y < 3; y++) {
          ArrayList<int[]> list = remember[x][y];
          for (int preIndex = list.size()-1; preIndex >= 0; preIndex--) {
            int[] lastMole = list.get(preIndex);
            int distance = Math.abs(mole[1]-x)+Math.abs(mole[2]-y);
            if (mole[0]-lastMole[0] >= distance) {
              dp[i] = Math.max(dp[i], lastMole[1]+1);
              break;
            }
          }
        }
      }
      if (dp[i] != 0) {
        remember[mole[1]][mole[2]].add(new int[]{mole[0], dp[i]});
      }
    }
    int result = 0;
    for (int x = 0; x < 3; x++) {
      for (int y = 0; y < 3; y++) {
        ArrayList<int[]> list = remember[x][y];
        if (list.size() != 0) {
          result = Math.max(result, list.get(list.size()-1)[1]);
        }
      }
    }
    return result;
  }
}
