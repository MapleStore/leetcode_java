package darren.gong.leetcode;

public class ComputeArea223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C-A)*(D-B) + (G-E)*(H-F);
        int midLeft = Math.max(A, E);
        int midRight = Math.min(C, G);
        int midHigh = Math.min(D, H);
        int midLow = Math.max(B, F);
        if (midHigh > midLow && midLeft < midRight) {
            sum -= (midHigh-midLow)*(midRight-midLeft);
        }
        return sum;
    }
}
