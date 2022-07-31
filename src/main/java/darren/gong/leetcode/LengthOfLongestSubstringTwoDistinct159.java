package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringTwoDistinct159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> winCharToNums = new HashMap<>();
        int targetNum = 0;
        int result = 0;
        while (right < s.length()) {
            int num = winCharToNums.getOrDefault(s.charAt(right), 0)+1;
            winCharToNums.put(s.charAt(right), num);
            if (num == 1) {
                targetNum++;
            }
            if (targetNum <= 2) {
                result = Math.max(result, right-left+1);
            }
            right++;
            while (targetNum > 2) {
                num = winCharToNums.getOrDefault(s.charAt(left), 0);
                winCharToNums.put(s.charAt(left), num-1);
                if (num == 1) {
                    targetNum--;
                }
                left++;
            }
        }
        return result;
    }
}
