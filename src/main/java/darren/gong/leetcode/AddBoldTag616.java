package darren.gong.leetcode;

import java.util.Arrays;

public class AddBoldTag616 {
  public String addBoldTag(String s, String[] dict) {
    int length = s.length();
    boolean[] bold = new boolean[length];
    char[] arr = s.toCharArray();
    for (int i = 0; i < length; i++) {
      for (String word : dict) {
        if (s.startsWith(word, i)) {
          Arrays.fill(bold, i, i+word.length(), true);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      if ((i == 0 || !bold[i-1]) && bold[i]) {
        sb.append("<b>");
      }
      sb.append(arr[i]);
      if ((i == length-1 || !bold[i+1]) && bold[i]) {
        sb.append("</b>");
      }
    }
    return sb.toString();
  }
}
