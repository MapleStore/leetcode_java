package darren.gong.leetcode;

public class ClosestDivisors_1362 {
  public int[] closestDivisors(int num) {
    int[] one = closestDivisorsHelper(num+1);
    int[] two = closestDivisorsHelper(num+2);
    return Math.abs(one[0]-one[1]) > Math.abs(two[0]-two[1]) ? two : one;
  }
  public int[] closestDivisorsHelper(int num) {
    int sqrt = (int)Math.sqrt(num);
    for (int oneNum = sqrt; oneNum >= 1; oneNum--) {
      int anotherNum = num/oneNum;
      if (anotherNum*oneNum == num) {
        return new int[]{oneNum, anotherNum};
      }
    }
    return new int[]{0, Integer.MAX_VALUE};
  }
}
