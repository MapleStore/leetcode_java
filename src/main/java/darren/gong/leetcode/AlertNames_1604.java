package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AlertNames_1604 {
  // 1604. 警告一小时内使用相同员工卡大于等于三次的人
  public static void main(String[] args) {
    AlertNames_1604 alertNames_1604 = new AlertNames_1604();
    alertNames_1604.alertNames(new String[]{"b","b","b","b"}, new String[]{"17:44","02:50","18:48","18:00"});
  }
  public List<String> alertNames(String[] keyName, String[] keyTime) {
    Map<String, List<Integer>[]> map = new HashMap<>();
    TreeSet<String> result = new TreeSet<>();
    int length = keyName.length;
    for (int i = 0; i < length; i++) {
      if (result.contains(keyName[i])) {
        continue;
      }
      List<Integer>[] times = map.computeIfAbsent(keyName[i], k->new List[24]);
      String[] currentTime = keyTime[i].split(":");
      int currentHour = Integer.parseInt(currentTime[0]);
      int currentMinute = Integer.parseInt(currentTime[1]);
      if (times[currentHour] == null) {
        for (int hour = 0; hour < 24; hour++) {
          times[hour] = new ArrayList<>();
        }
      }

      List<Integer> currentHourMinutes = times[currentHour];
      if (currentHourMinutes.size() >= 2) {
        result.add(keyName[i]);
        continue;
      }
      currentHourMinutes.add(currentMinute);
      Collections.sort(currentHourMinutes);
      for (int minIndex = 0; minIndex < currentHourMinutes.size(); minIndex++) {
        if (currentHour != 23) {
          int after = getBeforeTimeNum(times[currentHour+1], currentHourMinutes.get(minIndex));
          if (after+currentHourMinutes.size()-minIndex >= 3) {
            result.add(keyName[i]);
            break;
          }

        }
        if (currentHour != 0) {
          int before = getAfterTimeNum(times[currentHour-1], currentHourMinutes.get(minIndex));
          if (before+minIndex+1 >= 3) {
            result.add(keyName[i]);
            break;
          }
        }
      }
    }
    return new ArrayList<>(result);
  }

  private int getBeforeTimeNum(List<Integer> time, int targetTime) {
    for (int i = 0; i < time.size(); i++) {
      if (time.get(i) > targetTime) {
        return i;
      }
    }
    return time.size();
  }

  private int getAfterTimeNum(List<Integer> time, int targetTime) {
    for (int i = 0; i < time.size(); i++) {
      if (time.get(i) >= targetTime) {
        return time.size()-i;
      }
    }
    return 0;
  }
}
