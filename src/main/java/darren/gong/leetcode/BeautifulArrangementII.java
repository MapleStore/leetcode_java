package darren.gong.leetcode;

public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int maxBeautiful = k + 1;
        int minBeautiful = 1;
        int index = 0;
        int[] result = new int[n];
        while (index < k+1) {
            result[index++] = index%2 == 0 ? minBeautiful++ : maxBeautiful--;
        }
        while (index < n) {
            result[index++] = index+1;
        }
        return result;
    }
}
