package darren.gong.leetcode;

public class Divide {
    public static void main(String[] args) {
        Divide divide = new Divide();
        divide.divide(-1010369383, -2147483648);
    }
    public int divide(int dividend, int divisor) {
        boolean oneIsPossitive = true;
        boolean twoIsPossitive = true;
        long newDividend = (long) dividend;
        long newDivisor = (long) divisor;
        if (newDividend < 0) {
            oneIsPossitive = false;
            newDividend = -newDividend;
        }
        if (newDivisor < 0) {
            twoIsPossitive = false;
            newDivisor = -newDivisor;
        }
        if (newDividend < newDivisor) {
            return 0;
        }
        if (newDividend == newDivisor) {
            return oneIsPossitive != twoIsPossitive ? -1 : 1;
        }
        long[] subStracts = new long[33];
        long result = 0;
        for (int i = 0; i < subStracts.length; i++) {
            // i 32
            subStracts[i] = ((long) newDivisor << i);
        }
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = subStracts.length-1; i >= 0; i--) {
                if (newDividend >= subStracts[i]) {
                    end = false;
                    newDividend -= subStracts[i];
                    result += (1L << i);
                }
            }
        }
        if (oneIsPossitive != twoIsPossitive) {
            return result > 2147483647 ? -2147483648 : -(int)result;
        }
        return result > 2147483647 ? 2147483647 : (int)result;
    }
}
