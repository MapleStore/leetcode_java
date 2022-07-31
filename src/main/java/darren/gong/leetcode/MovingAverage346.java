package darren.gong.leetcode;

public class MovingAverage346 {
    public static void main(String[] args) {
        MovingAverage346 movingAverage346 = new MovingAverage346(3);
        movingAverage346.next(10);
        movingAverage346.next(3);
        movingAverage346.next(5);
    }
    int index = 0;
    double[] array;
    double value = 0;
    int size;
    int num = 0;
    /** Initialize your data structure here. */
    public MovingAverage346(int size) {
        array = new double[size];
        this.size = size;
    }

    public double next(int val) {
        value += val;
        if (num < size) {
            num++;
        }
        value -= array[index];
        array[index++] = val;
        index = index % size;
        return value / num;
    }

}
