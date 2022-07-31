package darren.gong.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeastInterval621 {
    public static void main(String[] args) {
        LeastInterval621 leastInterval621 = new LeastInterval621();
        leastInterval621.leastInterval(new char[]{'A','A','A','B','B','B'}, 2);
    }
    public int leastInterval(char[] tasks, int n) {
        Integer[] taskNum = new Integer[26];
        for (int i = 0; i < 26; i++) {
            taskNum[i] = 0;
        }
        for (char task : tasks) {
            taskNum[task-'A']++;
        }
        int result = 0;
        Arrays.sort(taskNum, (o1, o2) -> (o2-o1));
        while (taskNum[0] > 0) {
            for (int i = 0; i <= n; i++) {
                if (taskNum[0] == 0) {
                    break;
                }
                result++;
                if (i < 26 && taskNum[i] > 0) {
                    taskNum[i]--;
                }
            }
            Arrays.sort(taskNum, (o1, o2) -> (o2-o1));
        }
        return result;
    }
}
