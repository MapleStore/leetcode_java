package darren.gong.leetcode;

public class Compress443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int index = 0;
        char preChar = chars[0];
        int times = 0;
        for (char oneChar : chars) {
            if (oneChar == preChar) {
                times++;
            } else {
                chars[index++] = preChar;
                if (times != 1) {
                    int start = index;
                    while (times != 0) {
                        chars[index++] = (char)('0'+times%10);
                        times = times/10;
                    }
                    int end = index-1;
                    while (start < end) {
                        char temp = chars[start];
                        chars[start] = chars[end];
                        chars[end] = temp;
                        start++;
                        end--;
                    }
                }
                preChar = oneChar;
                times = 1;
            }
        }
        chars[index++] = preChar;
        if (times != 1) {
            int start = index;
            while (times != 0) {
                chars[index++] = (char)('0'+times%10);
                times = times/10;
            }
            int end = index-1;
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return index;
    }
}
