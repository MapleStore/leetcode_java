package darren.gong.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreSentencesSimilarTwo_737 {
  private Map<String, String> map = new HashMap<>();
  public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
    int length1 = words1.length;
    int length2 = words2.length;
    if (length1 != length2) {
      return false;
    }
    for (String word : words1) {
      map.put(word, word);
    }
    for (String word : words2) {
      map.put(word, word);
    }
    for (List<String> pair : pairs) {
      String word1 = pair.get(0);
      String word2 = pair.get(1);
      map.put(word1, word1);
      map.put(word2, word2);
    }
    for (List<String> pair : pairs) {
      String word1 = pair.get(0);
      String word2 = pair.get(1);
      merge(word1, word2);
    }
    for (int i = 0 ; i < length1; i++) {
      String parent1 = find(words1[i]);
      String parent2 = find(words2[i]);
      if (!parent1.equals(parent2)) {
        return false;
      }
    }
    return true;
  }
  private void merge(String a, String b) {
    map.put(find(a), find(b));
  }
  private String find(String a) {
    String parent = map.get(a);
    if (parent.equals(a)) {
      return a;
    }
    map.put(a, find(parent));
    return map.get(a);
  }
}
