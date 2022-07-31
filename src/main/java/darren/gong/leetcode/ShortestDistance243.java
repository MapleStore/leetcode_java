package darren.gong.leetcode;

public class ShortestDistance243 {
  public int shortestDistance(String[] words, String word1, String word2) {
    if (words == null || words.length == 0) {
      return -1;
    }
    int length = words.length;
    int result = Integer.MAX_VALUE;
    int indexOfWord1 = -1;
    int indexOfWord2 = -1;
    for (int i = 0; i < length; i++) {
      String current = words[i];
      if (current.equals(word1)) {
        if (indexOfWord2 != -1) {
          result = Math.min(result, i-indexOfWord2);
        }
        indexOfWord1 = i;
      }
      if (current.equals(word2)) {
        if (indexOfWord1 != -1) {
          result = Math.min(result, i-indexOfWord1);
        }
        indexOfWord2 = i;
      }
    }
    return result;
  }
}
