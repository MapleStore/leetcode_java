package darren.gong.leetcode;

import java.util.PriorityQueue;

public class MedianFinder295 {
    public static  void main(String[] args) {
        MedianFinder295 medianFinder295 = new MedianFinder295();
        medianFinder295.addNum(1);
        medianFinder295.addNum(2);
        medianFinder295.findMedian();
        medianFinder295.addNum(3);
        medianFinder295.findMedian();
    }
    // 默认小顶堆
    PriorityQueue<Integer> getSmallest = new PriorityQueue<>();
    PriorityQueue<Integer> getBiggest = new PriorityQueue<>((a, b)-> b-a);
    /** initialize your data structure here. */
    public MedianFinder295() {

    }

    public void addNum(int num) {
        getSmallest.add(num);
        getBiggest.add(getSmallest.poll());
        if (getSmallest.size() < getBiggest.size()) {
            getSmallest.add(getBiggest.poll());
        }
    }

    public double findMedian() {
        if (getSmallest.size() > getBiggest.size()) {
            return getSmallest.peek();
        }
        return (double) (getSmallest.peek()+getBiggest.peek())/(double) 2;
    }
}
