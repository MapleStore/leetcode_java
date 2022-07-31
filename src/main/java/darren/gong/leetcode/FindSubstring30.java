package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindSubstring30 {
  public static void main(String[] args) {
    FindSubstring30 findSubstring30 = new FindSubstring30();
    findSubstring30.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"});
  }
  public List<Integer> findSubstring(String s, String[] words) {
    if (s == null || s.length() == 0 || words == null || words.length == 0) {
      return new ArrayList<>();
    }
    int oneWordLength = words[0].length();
    int wordSize = words.length;
    int sLength = s.length();
    if (sLength%oneWordLength != 0) {
      return new ArrayList<>();
    }
    String[] strings = splitString(s, oneWordLength);
    int stringLength = strings.length;

    Map<String, Integer> sourceMap = new HashMap<>(wordSize);
    for (String word : words) {
      sourceMap.put(word, sourceMap.getOrDefault(word, 0)+1);
    }
    wordSize = sourceMap.size();
    List<Integer> result = new LinkedList<>();
    int currentMatchWord = 0;
    int right = 0;
    int left = 0;
    HashMap<String, Integer> currentMap = new HashMap<>(wordSize);
    while (right < stringLength) {
      if (!sourceMap.containsKey(strings[right])) {
        right++;
        left = right;
        currentMatchWord = 0;
        currentMap.clear();
        continue;
      } else if (currentMap.get(strings[right]) == sourceMap.get(strings[right])) {
        left++;
        right = left;
        currentMatchWord = 0;
        currentMap.clear();
        continue;
      }
      int appearTimes = currentMap.getOrDefault(strings[right], 0);
      currentMap.put(strings[right], appearTimes+1);
      if (appearTimes == sourceMap.get(strings[right])-1) {
        currentMatchWord++;
        if (currentMatchWord == wordSize) {
          result.add(left*oneWordLength);
          left++;
          right = left;
          currentMatchWord = 0;
          currentMap.clear();
          continue;
        }
      }
      right++;
    }
    return result;
  }


  public List<Integer> findSubstring1(String s, String[] words) {
    if (s == null || s.length() == 0 || words == null || words.length == 0) {
      return new ArrayList<>();
    }
    int oneWordLength = words[0].length();
    int wordSize = words.length;
    int sLength = s.length();
    int subStringLength = oneWordLength*wordSize;

    Map<String, Integer> sourceMap = new HashMap<>(wordSize);
    List<Integer> result = new LinkedList<>();
    for (String word : words) {
      sourceMap.put(word, sourceMap.getOrDefault(word, 0)+1);
    }
    for (int i = 0; i+subStringLength <= sLength; i++) {
      if (match(s.substring(i, i+subStringLength), sourceMap, oneWordLength)) {
        result.add(i);
      }
    }
    return result;
  }

  private boolean match(String s, Map<String, Integer> sourceMap, int oneWordLength) {
    int length = s.length();
    Map<String, Integer> currentHashMap = new HashMap<>(length/oneWordLength);
    for (int i = 0; i < length; i += oneWordLength) {
      String word = s.substring(i, i+oneWordLength);
      Integer sourceAppearTimes = sourceMap.get(word);
      if (sourceAppearTimes == null) {
        return false;
      }
      int currentAppearTimes = currentHashMap.getOrDefault(word, 0)+1;
      if (currentAppearTimes > sourceAppearTimes) {
        return false;
      }
      currentHashMap.put(word, currentAppearTimes);
    }
    return true;
  }


  private String[] splitString(String s, int wordLength) {
    int length = s.length();
    String[] result = new String[s.length()/wordLength];
    int index = 0;
    for (int i = 0; i < length; i += wordLength) {
      result[index++] = s.substring(i, i+wordLength);
    }
    return result;
  }
}
