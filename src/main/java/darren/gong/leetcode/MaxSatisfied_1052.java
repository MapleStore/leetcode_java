package darren.gong.leetcode;

import java.util.Arrays;

public class MaxSatisfied_1052 {
  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int customerCount = 0;
    int angryCustomerCount = 0;
    int length = customers.length;
    for (int i = 0; i < length; i++) {
      angryCustomerCount += (grumpy[i] == 1 ? customers[i] : 0);
      customerCount += customers[i];
    }

    int stopAngryCustomers = 0;
    int maxStopAngryCustomers = 0;
    for (int i = 0; i < length; i++) {
      stopAngryCustomers += (grumpy[i] == 1 ? customers[i] : 0);
      if (i >= minutes) {
        int begin = i-minutes;
        stopAngryCustomers -= (grumpy[begin] == 1 ? customers[begin] : 0);
      }
      maxStopAngryCustomers = Math.max(maxStopAngryCustomers, stopAngryCustomers);
    }
    return customerCount-(angryCustomerCount-maxStopAngryCustomers);
  }
}
