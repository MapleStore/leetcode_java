package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordDistance_244 {
  // 244. 最短单词距离 II
  private Map<String, ArrayList<Integer>> indexs = new HashMap<>();
  public WordDistance_244(String[] wordsDict) {
    int length = wordsDict.length;
    for (int i = 0; i < length; i++) {
      String current = wordsDict[i];
      indexs.computeIfAbsent(current, k->new ArrayList<>()).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    ArrayList<Integer> word1Indexs = indexs.get(word1);
    ArrayList<Integer> word2Indexs = indexs.get(word2);
    int currentWord2Index = 0;
    int currentWord1Index = 0;
    int result = Integer.MAX_VALUE;
    while (currentWord2Index < word2Indexs.size() && currentWord1Index < word1Indexs.size()) {
      int word1Value = word1Indexs.get(currentWord1Index);
      int word2Value = word2Indexs.get(currentWord2Index);
      result = Math.min(result, Math.abs(word2Value-word1Value));
      if (word2Value < word1Value) {
        currentWord2Index++;
      } else {
        currentWord1Index++;
      }
    }
    return result;
  }
}
