package darren.gong.leetcode;

public class RangeBitwiseAnd201 {
  public int rangeBitwiseAnd(int m, int n) {
    int allOne = 0xFFFFFFFF;
    int rightZeroNum = 0;
    while ((m&(allOne>>>rightZeroNum<<rightZeroNum)) != (n&(allOne>>>rightZeroNum<<rightZeroNum))) {
      rightZeroNum++;
    }
    return (m&(allOne>>>rightZeroNum<<rightZeroNum));
  }
}
