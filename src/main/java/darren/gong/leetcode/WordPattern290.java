package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
  public boolean wordPattern(String pattern, String s) {
    Map<Character, String> patternToString = new HashMap<>();
    Map<String, Character> stringToPattern = new HashMap<>();
    String[] stringArray = s.split(" ");
    if (pattern.length() != stringArray.length) {
      return false;
    }
    for (int i = 0; i < stringArray.length; i++) {
      Character key = stringToPattern.get(stringArray[i]);
      if (key != null && !key.equals(pattern.charAt(i))) {
        return false;
      }
      String value = patternToString.get(pattern.charAt(i));
      if (value != null && !value.equals(stringArray[i])) {
        return false;
      }
      stringToPattern.put(stringArray[i], pattern.charAt(i));
      patternToString.put(pattern.charAt(i), stringArray[i]);
    }
    return true;
  }
}
