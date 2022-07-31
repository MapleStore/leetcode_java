package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords_809 {
  // 809. 情感丰富的文字
  public static void main(String[] args) {
    ExpressiveWords_809 expressiveWords_809 = new ExpressiveWords_809();
    expressiveWords_809.expressiveWords("heeellooo",
        new String[]{"hello", "hi", "helo"});
  }
  public int expressiveWords(String S, String[] words) {
    List<int[]> target = values(S);
    int result = 0;
    for (String word : words) {
      if (canExtend(target, values(word))) {
        result++;
      }
    }
    return result;
  }
  private boolean canExtend(List<int[]> target, List<int[]> word) {
    int targetSize = target.size();
    int wordSize = word.size();
    if (targetSize != wordSize) {
      return false;
    }
    for (int i = 0; i < targetSize; i++) {
      int[] currentTarget = target.get(i);
      int[] currentWord = word.get(i);
      if (currentWord[0] == currentTarget[0] && currentWord[1] == currentTarget[1]) {
        continue;
      }
      if (currentWord[0] == currentTarget[0] && currentWord[1] < currentTarget[1] && currentTarget[1] >= 3) {
        continue;
      }
      return false;
    }
    return true;
  }
  private List<int[]> values(String word) {
    if (word == null || word.length() == 0) {
      return new ArrayList<>();
    }
    int charValue = word.charAt(0);
    int charAppears = 0;
    List<int[]> result = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == charValue) {
        charAppears++;
      } else {
        result.add(new int[]{charValue, charAppears});
        charValue = word.charAt(i);
        charAppears = 1;
      }
    }
    result.add(new int[]{charValue, charAppears});
    return result;
  }
}
