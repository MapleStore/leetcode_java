package darren.gong.leetcode;

public class DayOfTheWeek1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        int[] offset = new int[]{0,3,3,6,1,4,6,2,5,0,3,5};
        String[] weekDay = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int w = (day-1)+year+offset[month-1]+(year-1)/4-(year-1)/100+(year-1)/400;
        if (month > 2 && ((year%4 == 0 && year%100 != 0) || year%400 == 0)) {
            w++;
        }
        return weekDay[w%7];
    }
}
