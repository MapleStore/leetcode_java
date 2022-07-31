package darren.gong.leetcode;

public class Fib509 {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int fib1 = 0;
        int fib2 = 1;
        int result = 0;
        for (int i = 2; i <= N; i++) {
            result = fib1+fib2;
            fib1 = fib2;
            fib2 = result;
        }
        return result;
    }
}
