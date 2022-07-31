package darren.gong.leetcode;

public class MissingRolls_2028 {
  public int[] missingRolls(int[] rolls, int mean, int n) {
    int m = rolls.length;
    int sum = mean*(m+n);
    int[] result = new int[n];
    for (int value : rolls) {
      sum -= value;
    }

    if (sum > n*6 || sum < n) {
      return new int[0];
    }
    int index = 0;
    while (n > 0) {
      int current = sum/n;
      result[index++] = current;
      sum -= current;
      n--;
    }
    return result;
  }
}
