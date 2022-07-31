package darren.gong.leetcode;

public class ReverseOnlyLetters917 {
  public String reverseOnlyLetters(String S) {
    if (S == null) {
      return null;
    }
    if (S.length() == 0) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    int start = 0;
    int end = S.length()-1;
    char[] source = S.toCharArray();
    while (end >= 0 || start < S.length()) {
      if (start < S.length() && !isLetter(source[start])) {
        sb.append(source[start]);
        start++;
        continue;
      }
      if (end >= 0 && !isLetter(source[end])) {
        end--;
        continue;
      }
      sb.append(source[end]);
      start++;
      end--;
    }
    return sb.toString();
  }
  private boolean isLetter(char oneChar) {
    return (oneChar >= 'a' && oneChar <= 'z') || (oneChar >= 'A' && oneChar <='Z');
  }
}
