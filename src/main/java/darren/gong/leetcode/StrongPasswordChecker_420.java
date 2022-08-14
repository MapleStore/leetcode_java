package darren.gong.leetcode;

public class StrongPasswordChecker_420 {
  public int strongPasswordChecker(String password) {
    char[] chars = password.toCharArray();
    int smallChar = 0;
    int bigChar = 0;
    int digit = 0;
    for (char oneChar : chars) {
      if (oneChar >= 'a' && oneChar <= 'z') {
        smallChar = 1;
      }
      if (oneChar >= 'A' && oneChar <= 'Z') {
        bigChar = 1;
      }
      if (oneChar >= '0' && oneChar <= '9') {
        digit = 1;
      }
    }
    int charTypes = smallChar+bigChar+digit;
    int length = chars.length;
    if (length < 6) {
      return Math.max(6-length, 3-charTypes);
    } else {
      int[] count = new int[3];
      int needChangeToBreakTimes = 0;
      for (int i = 0; i < length;) {
        char currentChar = chars[i];
        int j = i+1;
        while (j < length && chars[j] == currentChar) j++;
        int times = j-i;
        if (times >= 3) {
          count[times%3]++;
          needChangeToBreakTimes += times/3;
        }
        i = j;
      }
      if (length <= 20) {
        return Math.max(needChangeToBreakTimes, 3-charTypes);
      }

      int canDelete = length-20;
      for (int i = 0; i < 3; i++) {
        if (i == 2) {
          count[i] = needChangeToBreakTimes;
        }
        int needDelete = Math.min(canDelete, count[i]*(i+1));
        needChangeToBreakTimes -= needDelete/(i+1);
        canDelete -= needDelete;
      }
      return length-20+Math.max(needChangeToBreakTimes, 3-charTypes);
    }
  }
}
