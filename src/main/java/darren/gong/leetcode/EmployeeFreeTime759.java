package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFreeTime759 {
    private class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if (schedule == null || schedule.isEmpty()) {
            return new ArrayList<>();
        }
        List<Interval> result = new ArrayList<>(schedule.size());
        List<Interval> all = new ArrayList<>(schedule.size());
        for (List<Interval> oneEmployee : schedule) {
            all.addAll(oneEmployee);
        }
        all.sort((a, b)->a.start-b.start);
        int endTime = all.get(0).end;
        for (Interval oneTime : all) {
            if (oneTime.start > endTime) {
                result.add(new Interval(endTime, oneTime.start));
            }
            endTime = Math.max(endTime, oneTime.end);
        }
        return result;
    }
}
