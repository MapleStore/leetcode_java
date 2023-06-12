package darren.gong.leetcode;

import java.util.Arrays;

public class UniqueLetterString_828 {
  public int uniqueLetterString(String s) {
    int length = s.length();
    int[] currentPreIndexs = new int[26];
    int[][] preIndexs = new int[length][26];
    Arrays.fill(currentPreIndexs, -1);
    for (int i = 0; i < length; i++) {
      currentPreIndexs[s.charAt(i)-'A'] = i;
      preIndexs[i] = Arrays.copyOf(currentPreIndexs, 26);
    }
    int result = 0;
    for (int i = 0; i < length; i++) {
      for (char val = 'A'; val <= 'Z'; val++) {
        int pre = preIndexs[i][val-'A'];
        if (pre == -1) {
          continue;
        }
        if (pre == 0) {
          result += 1;
          continue;
        }
        int secPre = preIndexs[pre-1][val-'A'];
        result += pre-secPre;
      }
    }
    return result;
  }
}
