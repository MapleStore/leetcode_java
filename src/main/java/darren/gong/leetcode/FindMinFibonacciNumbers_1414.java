package darren.gong.leetcode;

public class FindMinFibonacciNumbers_1414 {
  public int findMinFibonacciNumbers(int k) {
    if (k == 0) {
      return 0;
    }
    int one = 1;
    int two = 1;
    while (two <= k) {
      int three = one+two;
      one = two;
      two = three;
    }
    return findMinFibonacciNumbers(k-one)+1;
  }
}
