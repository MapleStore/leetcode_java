package darren.gong.leetcode;

public class CountAnagrams_2514 {
  public static void main(String[] args) {
    CountAnagrams_2514 countAnagrams_2514 = new CountAnagrams_2514();
    countAnagrams_2514.countAnagrams("too hot");
  }
  public int countAnagrams(String s) {
    String[] words = s.split(" ");
    long up = 1;
    long down = 1;
    for (String word : words) {
      long count[] = countWord(word);
      up *= count[0];
      up %= 1000000007;
      down *= count[1];
      down %= 1000000007;
    }
    return (int) (up*countInverse(down)%1000000007);
  }
  private long[] countWord(String word) {
    if (word.length() == 0) {
      return new long[]{1, 1};
    }
    long up = 1;
    for (int i = 2; i <= word.length(); i++) {
      up *= i;
      up %= 1000000007;
    }

    int[] digits = new int[26];
    for (char digit : word.toCharArray()) {
      digits[digit-'a']++;
    }
    long down = 1;
    for (int digit : digits) {
      while (digit > 1) {
        down *= digit--;
        down %= 1000000007;
      }
    }
    return new long[]{up, down};
  }
  private long countInverse(long num) {
    return pow(num, 1000000007-2);
  }
  private long pow(long val, long power) {
    if (power == 1) {
      return val;
    }
    if (power % 2 == 1) {
      return val*pow(val, power-1)%1000000007;
    }
    long halfPower = pow(val, power/2);
    return halfPower*halfPower%1000000007;
  }
}
