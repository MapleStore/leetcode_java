package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CanPermutePalindrome266 {
  public boolean canPermutePalindrome(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int oneNum = 0;
    for (char oneChar : s.toCharArray()) {
      int num = map.getOrDefault(oneChar, 0);
      if (num%2 == 0) {
        oneNum++;
      } else {
        oneNum--;
      }
      map.put(oneChar, num+1);
    }
    return oneNum <= 1;
  }
}
