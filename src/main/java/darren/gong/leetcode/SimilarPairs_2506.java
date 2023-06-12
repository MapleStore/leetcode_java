package darren.gong.leetcode;

public class SimilarPairs_2506 {
  public int similarPairs(String[] words) {
    int length = words.length;
    int result = 0;
    for (int i = 0; i < length; i++) {
      for (int j = i+1; j < length; j++) {
        int one = 0;
        int two = 0;
        for (char digit : words[i].toCharArray()) {
          one |= 1<<digit-'a';
        }
        for (char digit : words[j].toCharArray()) {
          two |= 1<<digit-'a';
        }
        if (one == two) {
          result++;
        }
      }
    }
    return result;
  }
}
