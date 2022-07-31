package darren.gong.leetcode;

public class ToHex405 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        char[] map = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        int temp = 0x000f;
        for (int i = 0; i < 8; i++) {
            sb.append(map[((temp<<(i*4)&num)>>>(i*4))]);
        }
        sb.reverse();
        while (sb.charAt(0)=='0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
