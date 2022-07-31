package darren.gong.leetcode.interview;

public class PatternMatching_1618 {
  public static void main(String[] args) {
    PatternMatching_1618 patternMatching_1618 = new PatternMatching_1618();
    patternMatching_1618.patternMatching("abaa", "dogdogdogdog");
  }
  public boolean patternMatching(String pattern, String value) {
    return dfs(pattern, value, 0, 0, new String[2]);
  }
  private boolean dfs(String pattern, String value, int patternIndex, int valueIndex, String[] map) {
    if (valueIndex == value.length() && patternIndex == pattern.length()) {
      return true;
    }
    if (patternIndex == pattern.length()) {
      return false;
    }
    char patternChar = pattern.charAt(patternIndex);
    String mapValue = map[patternChar-'a'];
    if (mapValue != null) {
      if (mapValue.equals("") || (valueIndex < value.length() && value.startsWith(mapValue, valueIndex))) {
        return dfs(pattern, value, patternIndex+1, valueIndex+mapValue.length(), map);
      }
      return false;
    }
    String anotherMapValue = map[0] == null ? map[1] : map[0];
    for (int index = valueIndex; index <= value.length(); index++) {
      String currentMapValue = value.substring(valueIndex, index);
      if (currentMapValue.equals(anotherMapValue)) {
        continue;
      }
      map[patternChar-'a'] = currentMapValue;
      if (dfs(pattern, value, patternIndex+1, valueIndex+currentMapValue.length(), map)) {
        return true;
      }
      map[patternChar-'a'] = null;
    }
    return false;
  }
}
