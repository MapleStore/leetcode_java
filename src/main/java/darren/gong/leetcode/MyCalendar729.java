package darren.gong.leetcode;

import java.util.TreeMap;

public class MyCalendar729 {
    private TreeMap<Integer, Integer> calendar = new TreeMap<>();
    public MyCalendar729() {

    }

    public boolean book(int start, int end) {
        Integer pre = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if ((pre == null || calendar.get(pre) <= start) && (next == null || next >= end)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
