package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int left = 0;
        int right = 0;
        int result = 0;
        int windowLength = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        while (right < s.length()) {
            char charAtRight = s.charAt(right);
            charCount.put(charAtRight, charCount.getOrDefault(charAtRight, 0)+1);
            windowLength++;
            if (charCount.get(charAtRight) == 1) {
                result = Math.max(windowLength, result);
            }
            right++;
            while (charCount.get(charAtRight) > 1) {
                char charAtLeft = s.charAt(left);
                windowLength--;
                charCount.put(charAtLeft, charCount.get(charAtLeft)-1);
                left++;
            }
        }
        return result;
    }
}
