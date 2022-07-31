package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NumMatchingSubseq_792 {
  public static void main(String[] args) {
    NumMatchingSubseq_792 numMatchingSubseq_792 = new NumMatchingSubseq_792();
    numMatchingSubseq_792.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"});
  }
  public int numMatchingSubseq(String s, String[] words) {
    List<StringBuilder>[] list = new List[26];
    for (int i = 0; i < 26; i++) {
      list[i] = new LinkedList<>();
    }
    for (String word : words) {
      int index = word.charAt(word.length()-1)-'a';
      list[index].add(new StringBuilder(word));
    }
    int result = 0;

    for (char oneChar : new StringBuilder(s).reverse().toString().toCharArray()) {
      List<StringBuilder> old = list[oneChar-'a'];
      list[oneChar-'a'] = new ArrayList<>();
      for (StringBuilder sb : old) {
        sb.deleteCharAt(sb.length()-1);
        if (sb.length() == 0) {
          result++;
          continue;
        }
        list[sb.charAt(sb.length()-1)-'a'].add(sb);
      }
    }
    return result;
  }
}
