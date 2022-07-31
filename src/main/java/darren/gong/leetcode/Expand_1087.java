package darren.gong.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Expand_1087 {
  public static void main(String[] args) {
    Expand_1087 expand_1087 = new Expand_1087();
    expand_1087.expand("{a,b}c{d,e}f");
  }
  private List<String> result = new LinkedList<>();
  public String[] expand(String S) {
    backTracking(S, 0, new StringBuilder());
    Collections.sort(result);
    return result.toArray(new String[result.size()]);
  }
  private void backTracking(String s, int index, StringBuilder sb) {
    if (index >= s.length()) {
      result.add(sb.toString());
      return;
    }
    char current = s.charAt(index);
    if (current != '{') {
      sb.append(current);
      backTracking(s, index+1, sb);
      sb.deleteCharAt(sb.length()-1);
      return;
    }
    int end = s.indexOf('}', index+1);
    for (int i = index+1; i < end; i++) {
      char currentChose = s.charAt(i);
      if (currentChose != ',') {
        sb.append(currentChose);
        backTracking(s, end+1, sb);
        sb.deleteCharAt(sb.length()-1);
      }
    }
  }
}
