package darren.gong.leetcode;

public class IsNumber65 {
  public static void main(String[] args) {
    IsNumber65 isNumber65 = new IsNumber65();
    isNumber65.isNumber("+.8");
  }
  public boolean isNumber(String s) {
    if (s == null || s.isEmpty()) {
      return false;
    }
    s = s.trim();
    if (s.isEmpty()) {
      return false;
    }
    int length = s.length();
    char[] sArr = s.toCharArray();
    boolean hasE = false;
    boolean hasPoint = false;
    for (int i = 0; i < length; i++) {
      char currentChar = sArr[i];
      if (!isValidateChar(currentChar)) {
        return false;
      }
      if (currentChar == '+' || currentChar == '-') {
        if (!followWithDigit(sArr, i)) {
          return false;
        }
        if (i > 0 && sArr[i-1] != 'e') {
          return false;
        }
      }
      if (currentChar == 'e') {
        if (hasE) {
          return false;
        }
        if (!preIsDigit(sArr, i)) {
          return false;
        }
        if (!followWithDigit(sArr, i) && !followWithAddAndDec(sArr, i)) {
          return false;
        }
        hasE = true;
      }
      if (currentChar == '.') {
        if (hasPoint) {
          return false;
        }
        boolean isValid = false;
        if (followWithDigit(sArr, i)) {
          isValid = true;
        }
        if (hasE) {
          return false;
        }
        if (preIsDigit(sArr, i)) {
          isValid = true;
        }
        if (!isValid) {
          return false;
        }
        hasPoint = true;
      }
    }
    return true;
  }

  private boolean followWithAddAndDec(char[] chars, int i) {
    if (i+1 >= chars.length || (chars[i+1] != '+' && chars[i+1] != '-')) {
      return false;
    }
    return true;
  }

  private boolean followWithDigit(char[] chars, int i) {
    if (i+1 < chars.length && (Character.isDigit(chars[i+1]) || chars[i+1] == '.')) {
      return true;
    }
    return false;
  }

  private boolean preIsDigit(char[] chars, int i) {
    if (i-1 >= 0 && (Character.isDigit(chars[i-1]) || chars[i-1] == '.')) {
      return true;
    }
    return false;
  }

  private boolean isValidateChar(char c) {
    if (c == '+' || c == '-' || c == 'e' || c == '.') {
      return true;
    }
    if (c <= '9' && c >= '0') {
      return true;
    }
    return false;
  }
}
