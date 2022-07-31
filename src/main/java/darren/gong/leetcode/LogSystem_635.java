package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class LogSystem_635 {
  private TreeMap<Long, Integer> treeMap = new TreeMap<>();
  private String[] granularities = new String[]{"Year", "Month", "Day", "Hour", "Minute", "Second"};
  private int timeLength = 15;
  public LogSystem_635() {

  }

  public void put(int id, String timestamp) {
    StringBuilder sb = new StringBuilder();
    String[] time = timestamp.split(":");
    for (String oneTime : time) {
      sb.append(oneTime);
    }
    treeMap.put(Long.parseLong(sb.toString())*10, id);
  }

  public List<Integer> retrieve(String start, String end, String granularity) {
    String[] startTime = start.split(":");
    String[] endTime = end.split(":");
    StringBuilder sbStart = new StringBuilder();
    StringBuilder sbEnd = new StringBuilder();
    int index = 0;
    for (String currentGranularity : granularities) {
      sbStart.append(startTime[index]);
      sbEnd.append(endTime[index]);
      index++;
      if (currentGranularity.equals(granularity)) {
        break;
      }
    }
    long startLong = Long.parseLong(sbStart.toString());
    startLong *= (long)Math.pow(10, timeLength-sbStart.length());
    while (sbEnd.length() < timeLength) {
      sbEnd.append('9');
    }
    long endLong = Long.parseLong(sbEnd.toString());
    endLong *= (long)Math.pow(10, timeLength-sbEnd.length());
    return new LinkedList<>(treeMap.subMap(startLong, endLong).values());
  }

}
