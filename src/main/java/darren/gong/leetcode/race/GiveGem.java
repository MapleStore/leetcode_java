package darren.gong.leetcode.race;

public class GiveGem {
  public static void main(String[] args) {
    GiveGem giveGem = new GiveGem();
    giveGem.giveGem(new int[]{3,1,2}, new int[][]{{0,0},{2,1},{2,0}});
  }
  public int giveGem(int[] gem, int[][] operations) {
    for (int[] operation : operations) {
      int half = gem[operation[0]]/2;
      gem[operation[1]] += half;
      gem[operation[0]] -= half;
    }
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int val : gem) {
      max = Math.max(max, val);
      min = Math.min(min, val);
    }
    return max-min;
  }
}
