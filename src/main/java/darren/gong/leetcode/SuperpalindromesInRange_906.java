package darren.gong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SuperpalindromesInRange_906 {
  public int superpalindromesInRange(String left, String right) {
    int result = 0;
    long leftLong = (long) Math.sqrt(Long.parseLong(left));
    long rightLong = (long) Math.sqrt(Long.parseLong(right));
    for (int length = String.valueOf(leftLong).length(); length <= String.valueOf(rightLong).length(); length++) {
      List<String> palindromes = palindromes(length);
      for (String palindrome : palindromes) {
        long val = Long.parseLong(palindrome);
        if (val > rightLong || val < leftLong) {
          continue;
        }
        if (valid(val*val)) {
          result++;
        }
      }
    }
    return result;
  }
  private boolean valid(long palindrome) {
    String palindromeStr = ""+palindrome;
    int left = 0;
    int right = palindromeStr.length()-1;
    while (left < right) {
      if (palindromeStr.charAt(left) != palindromeStr.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
  private List<String> palindromes(int length) {
    if (length == 1) {
      return Arrays.asList("0","1","2","3","4","5","6","7","8","9");
    }
    List<Long> midPalindromes = getMidPalindromes(length/2);
    List<String> result = new LinkedList<>();
    if (length%2 == 0) {
      for (long midPalindrome : midPalindromes) {
        result.add(""+midPalindrome+new StringBuilder(""+midPalindrome).reverse());
      }
      return result;
    }
    for (int i = 0; i <= 9; i++) {
      for (long midPalindrome : midPalindromes) {
        result.add(""+midPalindrome+i+new StringBuilder(""+midPalindrome).reverse());
      }
    }
    return result;
  }
  private List<Long> getMidPalindromes(int length) {
    List<Long> result = Arrays.asList(1L,2L,3L,4L,5L,6L,7L,8L,9L);
    while (length-- > 1) {
      List<Long> nextResult = new LinkedList<>();
      for (int i = 0; i <= 9; i++) {
        for (long one : result) {
          nextResult.add(one*10+i);
        }
      }
      result = nextResult;
    }
    return result;
  }
}
