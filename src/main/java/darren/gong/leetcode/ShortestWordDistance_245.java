package darren.gong.leetcode;

public class ShortestWordDistance_245 {
  // 245. 最短单词距离 III
  public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
    int posWord1 = -999999;
    int posWord2 = -999999;
    int result = Integer.MAX_VALUE;
    int length = wordsDict.length;
    for (int i = 0; i < length; i++) {
      String current = wordsDict[i];
      int tempPosWord1 = posWord1;
      int tempPosWord2 = posWord2;
      if (current.equals(word1)) {
        result = Math.min(result, i-posWord2);
        tempPosWord1 = i;
      }
      if (current.equals(word2)) {
        result = Math.min(result, i-posWord1);
        tempPosWord2 = i;
      }
      posWord1 = tempPosWord1;
      posWord2 = tempPosWord2;
    }
    return result;
  }
}
