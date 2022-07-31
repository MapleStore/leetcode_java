package darren.gong.leetcode;

public class NthUglyNumber264 {
  public int nthUglyNumber(int n) {
    if (n == 1) {
      return 1;
    }
    int l2 = 0;
    int l3 = 0;
    int l5 = 0;
    int[] uglyNums = new int[n];
    uglyNums[0] = 1;
    for (int i = 1; i < n; i++) {
      int numL2 = 2*uglyNums[l2];
      int numL3 = 3*uglyNums[l3];
      int numL5 = 5*uglyNums[l5];
      int min = Math.min(Math.min(numL2, numL3), numL5);
      if (numL2 == min) {
        l2++;
      }
      if (numL3 == min) {
        l3++;
      }
      if (numL5 == min) {
        l5++;
      }
      uglyNums[i] = min;
    }
    return uglyNums[n-1];
  }
}
