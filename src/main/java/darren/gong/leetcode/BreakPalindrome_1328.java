package darren.gong.leetcode;

public class BreakPalindrome_1328 {
  public String breakPalindrome(String palindrome) {
    int length = palindrome.length();
    if (length == 1) {
      return "";
    }
    char[] charArr = palindrome.toCharArray();
    int mid = length/2;
    for (int i = 0; i < mid; i++) {
      if (charArr[i] != 'a') {
        charArr[i] = 'a';
        return new String(charArr);
      }
    }
    int rightIndex = length%2 == 0 ? mid : mid+1;
    for (int i = rightIndex; i < length; i++) {
      if (charArr[i] != 'a') {
        charArr[i] = 'a';
        return new String(charArr);
      }
    }
    charArr[length-1]++;
    return new String(charArr);
  }
}
