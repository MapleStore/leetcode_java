package darren.gong.leetcode;

public class ReachNumber_754 {
  public int reachNumber(int target) {
    if (target < 0) {
      target = -target;
    }
    long low = 1;
    long high = 100000000;
    while (low <= high) {
      long mid = low+((high-low)>>>1);
      long value = (1+mid)*mid/2;
      if (value == target) {
        return (int)mid;
      }
      if (value > target) {
        high = mid-1;
      } else {
        low = mid+1;
      }
    }
    while (true) {
      long value = (1+low)*low/2;
      if ((value-target)%2 == 0) {
        return (int)low;
      }
      low++;
    }
  }
}
