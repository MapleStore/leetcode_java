package darren.gong.leetcode;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] times = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i)-'a';
            times[index]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (times[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
