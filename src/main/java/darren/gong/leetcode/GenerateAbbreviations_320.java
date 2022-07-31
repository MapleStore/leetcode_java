package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class GenerateAbbreviations_320 {
  // 320. 列举单词的全部缩写
  public static void main(String[] args) {
    GenerateAbbreviations_320 generateAbbreviations_320 = new GenerateAbbreviations_320();
    generateAbbreviations_320.generateAbbreviations("word");
  }
  private List<String> result = new LinkedList<>();
  public List<String> generateAbbreviations(String word) {
    backTracking(word, 0, new StringBuilder());
    return result;
  }
  private void backTracking(String word, int currentIndex, StringBuilder sb) {
    if (currentIndex >= word.length()) {
      result.add(sb.toString());
      return;
    }
    sb.append(word.charAt(currentIndex));
    backTracking(word, currentIndex+1, sb);
    sb.deleteCharAt(sb.length()-1);
    if (sb.length() != 0 && sb.charAt(sb.length()-1) >= '0' && sb.charAt(sb.length()-1) <= '9') {
      return;
    }
    int oldLength = sb.length();
    for (int i = 1; i <= word.length()-currentIndex; i++) {
      sb.append(i);
      backTracking(word, currentIndex+i, sb);
      sb.delete(oldLength, sb.length());
    }
  }
}
