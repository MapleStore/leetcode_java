package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CloseStrings_1657 {
  public boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }
    int[] word1Appear = new int[26];
    int[] word2Appear = new int[26];
    for (int i = 0; i < word1.length(); i++) {
      char word1Char = word1.charAt(i);
      char word2Char = word2.charAt(i);
      word1Appear[word1Char-'a']++;
      word2Appear[word2Char-'a']++;
    }
    Map<Integer, Integer> word1Size = new HashMap<>();
    Map<Integer, Integer> word2Size = new HashMap<>();
    for (int i = 0; i < 26; i++) {
      if ((word1Appear[i] != 0 && word2Appear[i] == 0) || (word1Appear[i] == 0 && word2Appear[i] != 0)) {
        return false;
      }
      if (word1Appear[i] == 0) {
        continue;
      }
      word1Size.put(word1Appear[i], word1Size.getOrDefault(word1Appear[i], 0)+1);
      word2Size.put(word2Appear[i], word2Size.getOrDefault(word2Appear[i], 0)+1);
    }
    for (Map.Entry<Integer, Integer> entry : word1Size.entrySet()) {
      if (entry.getValue() != word2Size.getOrDefault(entry.getKey(), 0)) {
        return false;
      }
    }
    return true;
  }
}
