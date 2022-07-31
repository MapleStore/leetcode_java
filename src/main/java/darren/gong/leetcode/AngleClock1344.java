package darren.gong.leetcode;

public class AngleClock1344 {
    public double angleClock(int hour, int minutes) {
        double min = (double)minutes*(double)360/(double)60;
        double h = (double)hour*(double)360/(double)12+(double)minutes*(double)30/(double)60;
        double value = (Math.max(min, h) - Math.min(min, h));
        return value > 180 ? (double)360-value : value;
    }
}
