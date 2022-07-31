package darren.gong.leetcode;

public class MinFlips_1529 {
  public int minFlips(String target) {
    int flipNum = 0;
    for (char oneChar : target.toCharArray()) {
      int num = oneChar-'0';
      if ((num+flipNum)%2 == 0) {
        continue;
      }
      flipNum++;
    }
    return flipNum;
  }
}
