package darren.gong.leetcode;

public class ConvertToTitle168 {
    public static void main(String[] args) {

    }
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n = n-1;
            sb.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
