package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GeneratePalindromes267 {
  public static void main(String[] args) {
    GeneratePalindromes267 generatePalindromes267 = new GeneratePalindromes267();
    generatePalindromes267.generatePalindromes("aabbcc");
  }
  public List<String> generatePalindromes(String s) {
    int[] times = new int[128];
    char[] array = s.toCharArray();
    for (char oneChar : array) {
      times[oneChar]++;
    }
    int oddChar = canGeneratePalindromes(times);
    if (oddChar == -2) {
      return new ArrayList<>();
    }
    int needToBeZero = 0;
    for (int i = 0; i < 128; i++) {
      if (times[i] > 0) {
        needToBeZero++;
      }
    }
    Set<String> result = new HashSet<>();
    backTracking(times, result, needToBeZero, oddChar, new StringBuilder());
    return new LinkedList<>(result);
  }

  private void backTracking(int[] target, Set<String> result, int needToBeZero, int oddChar, StringBuilder oneResult) {
    if (needToBeZero == 0) {
      if (oddChar == -1) {
        StringBuilder temp = new StringBuilder(oneResult);
        StringBuilder add = new StringBuilder().append(temp).append(temp.reverse());
        result.add(add.toString());
      } else {

        StringBuilder temp = new StringBuilder(oneResult);
        StringBuilder add = new StringBuilder().append(temp).append((char)oddChar).append(temp.reverse());
        result.add(add.toString());
      }
      return;
    }
    for (int i = 0; i < 128; i++) {
      if (target[i] == 0) {
        continue;
      }
      target[i]--;
      oneResult.append((char)i);
      if (target[i] == 0) {
        backTracking(target, result, needToBeZero-1, oddChar, oneResult);
      } else {
        backTracking(target, result, needToBeZero, oddChar, oneResult);
      }
      target[i]++;
      oneResult.deleteCharAt(oneResult.length()-1);
    }
  }
  private int canGeneratePalindromes(int[] times) {
    // -2 表示不可生成 -1表示全都是双数 否则表示单数的字符
    int index = -1;
    for (int i = 0; i < 128; i++) {
      if (times[i] % 2 == 1) {
        if (index != -1) {
          return -2;
        }
        index = i;
      }
      // 最后的times表示, 结果的一半是什么
      times[i] = times[i]/2;
    }
    return index;
  }
  private int isPalindromes(int[] times, StringBuilder sb) {
    for (int i = 0; i < sb.length(); i++) {
      times[sb.charAt(i)-'a']--;
    }
    int index = -1;
    for (int i = 0; i < 26; i++) {
      if (times[i] < 0) {
        return -1;
      }
      if (times[i] > 1) {
        return -1;
      }
      if (times[i] == 1) {
        if (index != -1) {
          return -1;
        }
        index = i;
      }
    }
    return index;
  }

}
