package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class WordSubsets_916 {
  // 916. 单词子集
  public List<String> wordSubsets(String[] words1, String[] words2) {
    int[] words2Count = getCount(words2);
    List<String> result = new LinkedList<>();
    for (String word : words1) {
      int[] wordCount = getCount(word);
      boolean valid = true;
      for (int i = 0; i < 26; i++) {
        if (wordCount[i] < words2Count[i]) {
          valid = false;
          break;
        }
      }
      if (valid) {
        result.add(word);
      }
    }
    return result;
  }
  private int[] getCount(String word) {
    int[] result = new int[26];
    for (char oneChar : word.toCharArray()) {
      result[oneChar-'a']++;
    }
    return result;
  }
  private int[] getCount(String[] words) {
    int[] result = new int[26];
    for (String word : words) {
      int[] one = getCount(word);
      for (int i = 0; i < 26; i++) {
        result[i] = Math.max(result[i], one[i]);
      }
    }
    return result;
  }
}
