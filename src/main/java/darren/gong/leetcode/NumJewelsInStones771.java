package darren.gong.leetcode;

public class NumJewelsInStones771 {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        boolean[] smallJewel = new boolean[26];
        boolean[] bigJewel = new boolean[26];
        int result = 0;
        for (char jewel : J.toCharArray()) {
            if (jewel >= 'a' && jewel <= 'z') {
                smallJewel[jewel-'a'] = true;
            } else if (jewel >= 'A' && jewel <= 'Z') {
                bigJewel[jewel-'A'] = true;
            }
        }
        for (char jewel : S.toCharArray()) {
            if (jewel >= 'a' && jewel <= 'z' && smallJewel[jewel-'a']) {
                result++;
            } else if (jewel >= 'A' && jewel <= 'Z' && bigJewel[jewel-'A']) {
                result++;
            }
        }
        return result;
    }
}
