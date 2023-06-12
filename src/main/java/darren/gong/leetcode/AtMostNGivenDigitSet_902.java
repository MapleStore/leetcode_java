package darren.gong.leetcode;

public class AtMostNGivenDigitSet_902 {
  public static void main(String[] args) {
    AtMostNGivenDigitSet_902 atMostNGivenDigitSet_902 = new AtMostNGivenDigitSet_902();
    atMostNGivenDigitSet_902.atMostNGivenDigitSet(new String[]{"5","6"}, 19);
  }
  public int atMostNGivenDigitSet(String[] digits, int n) {
    String nStr = String.valueOf(n);
    int result = 0;
    for (int i = 1; i < nStr.length(); i++) {
      result += Math.pow(digits.length, i);
    }
    boolean[] contains = new boolean[nStr.length()];
    for (int pos = 0; pos < nStr.length(); pos++) {
      for (String digitStr : digits) {
        char digit = digitStr.charAt(0);
        if (digit < nStr.charAt(pos)) {
          result += Math.pow(digits.length, nStr.length()-pos-1);
        } else if (digit == nStr.charAt(pos)) {
          contains[pos] = true;
        } else {
          break;
        }
      }
      if (!contains[pos]) {
        return result;
      }
    }
    return result+1;
  }
}
