package darren.gong.leetcode;

public class MaxRepOpt11156 {
    public static void main(String[] args) {
        MaxRepOpt11156 maxRepOpt11156 = new MaxRepOpt11156();
        maxRepOpt11156.maxRepOpt1("aabaaabaaaba");
    }
    public int maxRepOpt1(String text) {
        char[] charArray = text.toCharArray();
        int[] charAllNum = new int[26];
        int[] result = new int[26];
        int oneTimeNum = 0;
        for (int i = 0; i < charArray.length; i++) {
            charAllNum[charArray[i]-'a']++;
        }

        for (int i = 'a'; i <= 'z'; i++) {
            if (charAllNum[i-'a'] == 0) {
                continue;
            }
            int splitNum = 0;
            int numCount = 0;
            int startNum = -1;
            for (int j = 0; j < charArray.length;) {
                if (charArray[j] == i) {
                    if (splitNum == 1 && startNum == -1) {
                        startNum = j;
                    }
                    numCount++;
                } else if (splitNum >= 1) {
                    result[i-'a'] = charAllNum[i-'a'] > numCount ? Math.max(result[i-'a'], numCount+1) : Math.max(result[i-'a'], numCount);
                    splitNum = 0;
                    numCount = 0;
                    if (startNum != -1) {
                        j = startNum;
                        startNum = -1;
                        continue;
                    }
                } else {
                    splitNum++;
                }
                j++;
            }
            result[i-'a'] = charAllNum[i-'a'] > numCount ? Math.max(result[i-'a'], numCount+1) : Math.max(result[i-'a'], numCount);
        }
        int realResult = 0;
        for (int value : result) {
            realResult = Math.max(realResult, value);
        }
        return realResult;
    }
}
