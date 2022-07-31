package darren.gong.leetcode;

public class MinOperations_1775 {
  public int minOperations(int[] nums1, int[] nums2) {
    int sum1 = 0;
    int[] count1 = new int[7];
    for (int num1 : nums1) {
      sum1 += num1;
      count1[num1]++;
    }
    int sum2 = 0;
    int[] count2 = new int[7];
    for (int num2 : nums2) {
      sum2 += num2;
      count2[num2]++;
    }
    if (sum1 == sum2) {
      return 0;
    }
    int distance = Math.abs(sum1-sum2);
    if (sum1 < sum2) {
      int[] temp = count1;
      count1 = count2;
      count2 = temp;
    }
    int result = 0;
    // count1 bigger
    for (int i = 1; i < 6; i++) {
      int oneVal = (6-i);
      int val = oneVal*count1[7-i];
      if (val >= distance) {
        return result+(distance%oneVal == 0 ? (distance/oneVal) : (distance/oneVal)+1);
      } else {
        distance -= val;
        result += count1[7-i];
      }

      val = oneVal*count2[i];
      if (val >= distance) {
        return (distance%oneVal == 0) ? result+(distance/oneVal) : result+(distance/oneVal)+1;
      } else {
        distance -= val;
        result += count2[i];
      }
    }
    return -1;
  }
}
