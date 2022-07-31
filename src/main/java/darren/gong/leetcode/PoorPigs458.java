package darren.gong.leetcode;

public class PoorPigs458 {
  public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    int statues = minutesToTest/minutesToDie+1;
    return (int)Math.ceil(Math.log(buckets)/Math.log(statues));
  }
}
