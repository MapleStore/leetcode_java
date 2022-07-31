package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumLengthEncoding_820 {
  public static void main(String[] args) {
    MinimumLengthEncoding_820 minimumLengthEncoding_820 = new MinimumLengthEncoding_820();
    minimumLengthEncoding_820.minimumLengthEncoding(new String[]{"bell","ttimee","eme","time","me","l"});
  }
  public int minimumLengthEncoding(String[] words) {
    Arrays.sort(words, (a,b)->b.length()-a.length());
    Set<String> set = new HashSet<>();
    int result = 0;
    for (String word : words) {
      if (set.contains(word)) {
        continue;
      }
      result += word.length()+1;
      for (int i = 0; i < word.length(); i++) {
        set.add(word.substring(i));
      }
    }
    return result;
  }
}
