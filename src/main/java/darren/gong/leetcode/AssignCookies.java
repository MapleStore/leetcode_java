package darren.gong.leetcode;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int indexG = 0;
        int indexS = 0;
        while (indexG < g.length && indexS < s.length) {
            if (s[indexS] >= g[indexG]) {
                indexG++;
            }
            indexS++;
        }
        return indexG;
    }

}
