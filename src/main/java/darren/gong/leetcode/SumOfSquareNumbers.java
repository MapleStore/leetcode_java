package darren.gong.leetcode;

public class SumOfSquareNumbers {
    public static void main(String[] args){
    }
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int big = (int)Math.sqrt(c);
        int small = 0;
        while (big > small) {
            int result = big * big + small * small;
            if (result == c) {
                return true;
            } else if (result > c) {
                big--;
            } else {
                small++;
            }
        }
        return false;
    }

}
