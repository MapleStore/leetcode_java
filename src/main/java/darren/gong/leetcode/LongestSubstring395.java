package darren.gong.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LongestSubstring395 {
  // 贪心
  public int longestSubstringGreed(String s, int k) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int length = s.length();
    if (k > length) {
      return 0;
    }

    char[] array = s.toCharArray();
    Deque<Integer>[] deque = new Deque[26];
    for (int i = 0; i < 26; i++) {
      deque[i] = new ArrayDeque<>();
    }

    int[] lastIndex = new int[length];
    for (int i = 0; i < length; i++) {
      Deque targetDeque = deque[array[i]-'a'];
      deque[array[i]-'a'].addLast(i);
      if (targetDeque.size() == k) {
        lastIndex[(int) targetDeque.getFirst()] = (int)targetDeque.getLast();
        targetDeque.removeFirst();
      }
    }

    for (int i = 0; i < 26; i++) {
      Deque targetDeque = deque[i];
      while (!targetDeque.isEmpty()) {
        lastIndex[(int) targetDeque.removeFirst()] = Integer.MAX_VALUE;
      }
    }

    int result = 0;
    for (int i = 0; i < length-k+1; i++) {
      int end = lastIndex[i];
      if (end == Integer.MAX_VALUE) {
        continue;
      }
      boolean[] appearedChar = new boolean[26];
      for (int j = i; j < length; j++) {
        if (!appearedChar[array[j]-'a']) {
          end = Math.max(lastIndex[j], end);
          if (end == Integer.MAX_VALUE) {
            break;
          }
          appearedChar[array[j]-'a'] = true;
        }
        if (j >= end) {
          result = Math.max(result, j-i+1);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    LongestSubstring395 longestSubstring395 = new LongestSubstring395();
    longestSubstring395.longestSubstringDivide("ababacb", 3);
  }
  // 分治法
  public int longestSubstringDivide(String s, int k) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int length = s.length();
    if (k > length) {
      return 0;
    }
    return longestSubstringDivideHelper(s, k, 0, s.length()-1);
  }

  public int longestSubstringDivideHelper(String s, int k, int start, int end) {
    int[] times = new int[26];
    for (int i = start; i <= end; i++) {
      times[s.charAt(i)-'a']++;
    }
    while (end-start+1 >= k && times[s.charAt(start)-'a'] < k) start++;
    while (end-start+1 >= k && times[s.charAt(end)-'a'] < k) end--;
    if (end-start+1 < k) {
      return 0;
    }

    for (int i = start+1; i < end; i++) {
      if (times[s.charAt(i)-'a'] < k) {
        return Math.max(longestSubstringDivideHelper(s, k, start, i-1), longestSubstringDivideHelper(s, k, i+1, end));
      }
    }
    return end-start+1;
  }


}
