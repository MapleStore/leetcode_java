package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSecretWord843 {
  interface Master {
    public int guess(String word);
  }

  public void findSecretWord(String[] wordlist, Master master) {
    if (wordlist == null || wordlist.length == 0) {
      return;
    }
    Arrays.sort(wordlist);
    Map<String, Integer> wordToMatchNum = new HashMap<>();
    for (int i = 0; i < wordlist.length; i++) {
      String currentWord = wordlist[i];
      boolean matchFlag = true;
      for (Map.Entry<String, Integer> entry : wordToMatchNum.entrySet()) {
        int matchNum = matchNum(currentWord, entry.getKey());
        if (matchNum != entry.getValue()) {
          matchFlag = false;
        }
      }
      if (matchFlag) {
        int matchNum = master.guess(currentWord);
        if (matchNum == 6) {
          return;
        }
        wordToMatchNum.put(currentWord, matchNum);
      }
    }
  }

  private int matchNum(String currentWord, String targetWord) {
    int result = 0;
    for (int i = 0; i < 6; i++) {
      if (currentWord.charAt(i) == targetWord.charAt(i)) {
        result++;
      }
    }
    return result;
  }

}
