package darren.gong.leetcode;

public class FindJudge997 {
  public int findJudge(int N, int[][] trust) {
    int[] beTrusted = new int[N+1];
    boolean[] trustOther = new boolean[N+1];
    for (int[] oneTrust : trust) {
      beTrusted[oneTrust[1]]++;
      trustOther[oneTrust[0]] = true;
    }
    for (int i = 1; i <= N; i++) {
      if (beTrusted[i] == N-1 && !trustOther[i]) {
        return i;
      }
    }
    return -1;
  }
}
