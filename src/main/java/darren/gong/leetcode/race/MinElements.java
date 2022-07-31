package darren.gong.leetcode.race;

public class MinElements {
  public static void main(String[] args) {
    System.out.println(Integer.MAX_VALUE);
  }
  public int minElements(int[] nums, int limit, int goal) {
    long sum = 0;
    for (int num : nums) {
      sum += num;
    }

    long value = Math.abs((long)goal-sum);
    long result = Math.abs(value)/(long)limit;
    return (int)(result*(long)limit == value ? result : result+1);
  }
}
