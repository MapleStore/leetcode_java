package darren.gong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Logger359 {
  private Logs[] logs = new Logs[10];
  private class Logs {
    int timestamp;
    Set<String> logs;
    Logs(int timestamp) {
      this.timestamp = timestamp;
      logs = new HashSet<>();
    }
  }
  /** Initialize your data structure here. */
  public Logger359() {
    for (int i = 0; i < logs.length; i++) {
      logs[i] = new Logs(-1);
    }
  }

  /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
   If this method returns false, the message will not be printed.
   The timestamp is in seconds granularity. */
  public boolean shouldPrintMessage(int timestamp, String message) {
    int clearTimestamp = timestamp-10;
    boolean shouldPrint = true;
    for (int i = 0; i < logs.length; i++) {
      if (logs[i].timestamp < clearTimestamp) {
        /*logs[i].timestamp = timestamp;*/
        logs[i].logs.clear();
      } else if (logs[i].logs.contains(message)) {
        shouldPrint = false;
      }
    }
    if (shouldPrint) {
      logs[timestamp%10].timestamp = timestamp;
      logs[timestamp%10].logs.add(message);
    }
    return shouldPrint;
  }
}
