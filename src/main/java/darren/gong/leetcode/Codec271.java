package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec271 {
  private String split = ""+(char)257;
  private static final String EMPTY = ""+(char)258;
  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    if (strs == null) {
      return null;
    }
    if (strs.size() == 0) {
      return EMPTY;
    }
    StringBuilder sb = new StringBuilder();
    for (String str : strs) {
      sb.append(str).append(split);
    }
    return sb.deleteCharAt(sb.length()-1).toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    if (s == null) {
      return null;
    }
    if (s.length() == EMPTY.length() && EMPTY.equals(s)) {
      return new ArrayList<>();
    }
    return new ArrayList<>(Arrays.asList(s.split(split, -1)));
  }
}
