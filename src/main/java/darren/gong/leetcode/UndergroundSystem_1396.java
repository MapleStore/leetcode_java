package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem_1396 {
  // 1396. 设计地铁系统
  private class StationAndTime {
    private String stationName;
    private int time;
    private StationAndTime(String stationName, int time) {
      this.stationName = stationName;
      this.time = time;
    }
  }
  private Map<Integer, StationAndTime> peopleEnter = new HashMap<>();
  // time sum, appear times
  private Map<String, long[]> travelCostTime = new HashMap<>();

  public UndergroundSystem_1396() {

  }

  public void checkIn(int id, String stationName, int t) {
    peopleEnter.put(id, new StationAndTime(stationName, t));
  }

  public void checkOut(int id, String stationName, int t) {
    StationAndTime enter = peopleEnter.get(id);
    long thisTravelTime = t-enter.time;
    String travel = enter.stationName+"@"+stationName;
    long[] timeSum = travelCostTime.getOrDefault(travel, new long[]{0, 0});
    travelCostTime.put(travel, new long[]{timeSum[0]+thisTravelTime, timeSum[1]+1});
  }

  public double getAverageTime(String startStation, String endStation) {
    String travel = startStation+"@"+endStation;
    long[] timeSum = travelCostTime.getOrDefault(travel, new long[]{-1, 1});
    return (double)timeSum[0]/(double)timeSum[1];
  }
}
