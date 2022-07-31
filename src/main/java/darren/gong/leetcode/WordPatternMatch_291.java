package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPatternMatch_291 {
  // 291. 单词规律 II
  public static void main(String[] args) {
    WordPatternMatch_291 wordPatternMatch_291 = new WordPatternMatch_291();
    wordPatternMatch_291.wordPatternMatch("abab", "redblueredblue");
  }
  private String[] map1 = new String[26];
  private Map<String, Character> map2 = new HashMap<>();
  public boolean wordPatternMatch(String pattern, String s) {
    return dfs(pattern, 0, s, 0);
  }
  private boolean dfs(String pattern, int patternIndex, String s, int sIndex) {
    if (patternIndex == pattern.length() && sIndex == s.length()) {
      return true;
    }
    if (patternIndex == pattern.length() || sIndex == s.length()) {
      return false;
    }
    char patternChar = pattern.charAt(patternIndex);
    String mapString = map1[patternChar-'a'];
    if (mapString != null) {
      if (s.indexOf(mapString, sIndex) == sIndex) {
        return dfs(pattern, patternIndex+1, s, sIndex+mapString.length());
      }
      return false;
    }
    for (int i = sIndex+1; i <= s.length(); i++) {
      mapString = s.substring(sIndex, i);
      if (map2.containsKey(mapString)) {
        continue;
      }
      map1[patternChar-'a'] = mapString;
      map2.put(mapString, patternChar);
      if (dfs(pattern, patternIndex+1, s, i)) {
        return true;
      }
      map1[patternChar-'a'] = null;
      map2.remove(mapString);
    }
    return false;
  }
}
