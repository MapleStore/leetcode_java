package darren.gong.leetcode;

import java.util.PriorityQueue;

public class ReorganizeString767 {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        int[] charToTimes = new int[26];
        for (char oneChar : S.toCharArray()) {
            charToTimes[oneChar-'a']++;
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b)->b[1]-a[1]);
        for (int i = 0; i < charToTimes.length; i++) {
            if (charToTimes[i] != 0) {
                priorityQueue.add(new int[]{i, charToTimes[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            int[] top = priorityQueue.poll();
            if (sb.length() == 0 || sb.charAt(sb.length()-1)-'a' != top[0]) {
                sb.append((char)('a'+top[0]));
                top[1]--;
                if (top[1] != 0) {
                    priorityQueue.add(top);
                }
                continue;
            }
            if (!priorityQueue.isEmpty()) {
                int[] second = priorityQueue.poll();
                sb.append((char)('a'+second[0]));
                second[1]--;
                if (second[1] != 0) {
                    priorityQueue.add(second);
                }
                priorityQueue.add(top);
                continue;
            }
            priorityQueue.add(top);
            break;
        }
        if (priorityQueue.isEmpty()) {
            return sb.toString();
        }
        return "";
    }
}
