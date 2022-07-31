package darren.gong.leetcode;

public class MinPartitions_1689 {
  public int minPartitions(String n) {
    int result = 0;
    for (char oneChar : n.toCharArray()) {
      result = Math.max(result, oneChar-'0');
    }
    return result;
  }
}
