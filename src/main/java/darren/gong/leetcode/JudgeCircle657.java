package darren.gong.leetcode;

public class JudgeCircle657 {
  private static int[][] directions = new int[26][2];
  static {
    directions['R'-'A'] = new int[]{1,0};
    directions['L'-'A'] = new int[]{-1,0};
    directions['U'-'A'] = new int[]{0,1};
    directions['D'-'A'] = new int[]{0,-1};
  }
  public boolean judgeCircle(String moves) {
    int[] start = new int[]{0,0};
    for (char move : moves.toCharArray()) {
      int[] direction = directions[move-'A'];
      start[0] = start[0]+direction[0];
      start[1] = start[1]+direction[1];
    }
    return start[0] == 0 && start[1] == 0;
  }
}
