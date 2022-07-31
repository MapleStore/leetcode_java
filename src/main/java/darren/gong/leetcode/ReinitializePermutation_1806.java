package darren.gong.leetcode;

public class ReinitializePermutation_1806 {
  public static void main(String[] args) {
    ReinitializePermutation_1806 reinitializePermutation_1806 = new ReinitializePermutation_1806();
    reinitializePermutation_1806.reinitializePermutation(4);
  }
  public int reinitializePermutation(int n) {
    if (n == 2) {
      return 1;
    }
    int[] count = new int[n];
    for (int i = 0; i < n; i++) {
      count[i] = i;
    }
    int half = n/2;
    for (int i = 1; i < n-1; i++) {
      int val = 0;
      int current = i;
      while (true) {
        int next = current < half ? current*2 : 2*current+1-n;
        val++;
        if (next == i) {
          break;
        }
        current = next;
      }
      count[i] = val;
    }
    int result = 1;
    for (int i = 1; i < n-1; i++) {
      result = result*count[i]/getGCD(result, count[i]);
    }
    return result;
  }
  private int getGCD(int a, int b) {
    if (a == b) {
      return a;
    }
    // swap
    if (a < b) {
      a = a+b;
      b = a-b;
      a = a-b;
    }
    while (true) {
      int c = a%b;
      if (c == 0) {
        return b;
      }
      a = b;
      b = c;
    }
  }
}
