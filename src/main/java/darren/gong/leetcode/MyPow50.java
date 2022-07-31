package darren.gong.leetcode;

public class MyPow50 {
    public double myPow(double x, int n) {
        if (n >= 0) {
            return myPowTemp(x, n);
        } else {
            return ((double)1) / myPowTemp(x, -n);
        }
    }
    public double myPowTemp(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double result = myPowTemp(x, n/2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
    }

}
