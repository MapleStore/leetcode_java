package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class FullJustify68 {
  public static void main(String[] args) {
    FullJustify68 fullJustify68 = new FullJustify68();
    fullJustify68.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
  }
  public List<String> fullJustify(String[] words, int maxWidth) {
    int length = words.length;
    int currentLineLength = 0;
    int currentLineWordLength = 0;
    int right = 0;
    int left = 0;
    List<String> result = new LinkedList<>();
    while (right < length) {
      String currentWord = words[right];
      int currentWordLength = currentWord.length();
      currentLineWordLength += currentWordLength;
      if (right == length-1) {
        //最后一行，当前为最后一行最后一个
        result.add(generateLastLine(words, left, right, maxWidth, currentLineWordLength));
        currentLineWordLength = 0;
        currentLineLength = 0;
        right++;
      } else if (currentLineLength+currentWordLength+1+words[right+1].length() > maxWidth) {
        //下一个装不下了，当前为一行最后一个
        result.add(generateOneLine(words, left, right, maxWidth, currentLineWordLength));
        currentLineWordLength = 0;
        currentLineLength = 0;
        left = right = right+1;
      } else {
        //下一个装得下
        currentLineLength = currentLineLength+currentWordLength+1;
        right++;
      }
    }
    return result;
  }
  private String generateOneLine(String[] words, int left, int right, int maxWidth, int lineWordLength) {
    int spaceSumNum = maxWidth-lineWordLength;
    if (left == right) {
      StringBuilder result = new StringBuilder();
      result.append(words[left]);
      for (int i = 0; i < spaceSumNum; i++) {
        result.append(' ');
      }
      return result.toString();
    }

    int spaceNum = right-left;
    StringBuilder[] spaces = new StringBuilder[spaceNum];
    for (int i = 0; i < spaceNum; i++) {
      spaces[i] = new StringBuilder();
    }
    for (int i = 0; i < spaceSumNum; i++) {
      spaces[i%spaceNum].append(' ');
    }
    StringBuilder result = new StringBuilder();
    int index = 0;
    for (int i = left; i <= right; i++) {
      result.append(words[i]);
      if (i != right) {
        result.append(spaces[index++].toString());
      }
    }
    return result.toString();
  }
  private String generateLastLine(String[] words, int left, int right, int maxWidth, int lineWordLength) {
    StringBuilder result = new StringBuilder();
    for (int i = left; i <= right; i++) {
      result.append(words[i]);
      if (i != right) {
        result.append(' ');
        lineWordLength++;
      }
    }
    for (int i = lineWordLength; i < maxWidth; i++) {
      result.append(' ');
    }
    return result.toString();
  }

}
