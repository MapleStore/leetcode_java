package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class FindAndReplacePattern_890 {
  // 890. 查找和替换模式
  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> result = new LinkedList<>();
    int length = pattern.length();
    for (String word : words) {
      char[] wordToPattern = new char[26];
      char[] patternToWord = new char[26];
      for (int i = 0; i < length; i++) {
        char wordChar = word.charAt(i);
        char patternChar = pattern.charAt(i);
        if (wordToPattern[wordChar-'a'] == 0) {
          wordToPattern[wordChar-'a'] = patternChar;
        } else if (wordToPattern[wordChar-'a'] != patternChar) {
          break;
        }
        if (patternToWord[patternChar-'a'] == 0) {
          patternToWord[patternChar-'a'] = wordChar;
        } else if (patternToWord[patternChar-'a'] != wordChar) {
          break;
        }
        if (i == length-1) {
          result.add(word);
        }
      }
    }
    return result;
  }
}
