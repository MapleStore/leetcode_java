package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestArithSeqLength1027 {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }
        // index, 等差数列的差值, 这个差值的最大长度
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(i, new HashMap<>());
        }
        int[] dp = new int[A.length+1];
/*
        for (int i = 0; i < A.length; i++) {
            dp[i] = 1;
        }
*/
        for (int i = 2; i <= A.length; i++) {
            for (int preIndex = 1; preIndex < i; preIndex++) {
                int distance = A[i-1]-A[preIndex-1];
                int nowLength = map.get(preIndex-1).getOrDefault(distance, 1)+1;
                map.get(i-1).put(distance, nowLength);
                dp[i] = Math.max(dp[i], nowLength);
            }
        }
        int result = 0;
        for (int i = 2; i <= A.length; i++) {
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
