package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs336 {
  public static void main(String[] args) {
    PalindromePairs336 palindromePairs336 = new PalindromePairs336();
    palindromePairs336.palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"});
  }
  public List<List<Integer>> palindromePairs(String[] words) {
    if (words == null || words.length == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    int length = words.length;
    Map<String, Integer> stringToIndex = new HashMap<>(length);
    for (int i = 0; i < length; i++) {
      stringToIndex.put(words[i], i);
    }
    for (int i = 0; i < length; i++) {
      String currentWord = words[i];
      int currentWordLength = currentWord.length();
      for (int j = -1; j < currentWordLength; j++) {
        // pre Palindrome
        if (isPalindrome(currentWord, 0, j)) {
          Integer preIndex = stringToIndex.get(new StringBuilder(currentWord.substring(j+1)).reverse().toString());
          if (preIndex != null && preIndex != i) {
            result.add(new ArrayList<>(Arrays.asList(preIndex, i)));
          }
        }
        // end Palindrome
        if (j != -1 && isPalindrome(currentWord, j, currentWordLength-1)) {
          Integer endIndex = stringToIndex.get(new StringBuilder(currentWord.substring(0, j)).reverse().toString());
          if (endIndex != null && endIndex != i) {
            result.add(new ArrayList<>(Arrays.asList(i, endIndex)));
          }
        }
      }
    }
    return result;
  }
  private boolean isPalindrome(String s, int startIndex, int endIndex) {
    if (startIndex >= endIndex) {
      return true;
    }
    while (startIndex <= endIndex) {
      if (s.charAt(startIndex) != s.charAt(endIndex)) {
        return false;
      }
      startIndex++;
      endIndex--;
    }
    return true;
  }
}
