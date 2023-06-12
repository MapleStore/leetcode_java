package darren.gong.leetcode;

public class FindIntegers_600 {
  public static void main(String[] args) {
    FindIntegers_600 findIntegers_600 = new FindIntegers_600();
    findIntegers_600.findIntegers(16);
  }
  public int findIntegers(int n) {
    long[] preWork = new long[33];
    for (int i = 2; i <= 32; i++) {
      // i=0 i=1&i-1=1 i=1&i-1=0
      preWork[i] = preWork[i-1]+(1<<(i-2))+preWork[i-2];
    }
    int result = 0;
    int count1 = 0;
    for (int i = 31; i >= 0; i--) {
      if ((n&(1<<i)) == 0) {
        if (count1 == 1) {
          count1 = 0;
        }
        continue;
      }
      if (count1 >= 2) {
        result += (1<<i);
      } else {
        result += preWork[i];
      }
      count1++;
    }
    if (count1 >= 2) {
      result++;
    }
    return n+1-result;
  }
}
