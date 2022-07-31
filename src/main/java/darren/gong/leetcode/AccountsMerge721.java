package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge721 {
  public static void main(String[] args) {
    List<List<String>> accounts = new ArrayList<>();
    accounts.add(new ArrayList<>(Arrays.asList(new String[]{"David","David0@m.co","David4@m.co","David3@m.co"})));
    accounts.add(new ArrayList<>(Arrays.asList(new String[]{"David","David5@m.co","David5@m.co","David0@m.co"})));
    accounts.add(new ArrayList<>(Arrays.asList(new String[]{"David","David1@m.co","David4@m.co","David0@m.co"})));
    accounts.add(new ArrayList<>(Arrays.asList(new String[]{"David","David0@m.co","David1@m.co","David3@m.co"})));
    accounts.add(new ArrayList<>(Arrays.asList(new String[]{"David","David4@m.co","David1@m.co","David3@m.co"})));
    AccountsMerge721 accountsMerge721 = new AccountsMerge721();
    accountsMerge721.accountsMerge(accounts);
  }

  /*
  * [["David","David0@m.co","David4@m.co","David3@m.co"],
  * ["David","David5@m.co","David5@m.co","David0@m.co"],
  * ["David","David1@m.co","David4@m.co","David0@m.co"],
  * ["David","David0@m.co","David1@m.co","David3@m.co"],
  * ["David","David4@m.co","David1@m.co","David3@m.co"]]*/
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, Integer> map = new HashMap<>();
    Set<String>[] tempResult = new HashSet[accounts.size()];
    for (int i = 0; i < accounts.size(); i++) {
      tempResult[i] = new HashSet<>(accounts.get(i));
    }

    for (int i = 0; i < accounts.size(); i++) {
      List<String> account = accounts.get(i);
      for (int j = 1; j < account.size(); j++) {
        String u = account.get(j);
        if (!map.containsKey(u)) {
          map.put(u, i);
        }
        if (map.get(u) != i) {
          merge(map.get(u), i, tempResult, accounts, map);
        }
      }
    }
    List<List<String>> result = new LinkedList<>();
    for (int i = 0; i < tempResult.length; i++) {
      if (tempResult[i] == null) {
        continue;
      }
      List<String> list = new ArrayList<>();
      tempResult[i].remove(accounts.get(i).get(0));
      list.addAll(tempResult[i]);
      Collections.sort(list);
      list.add(0, accounts.get(i).get(0));
      result.add(list);
    }
    return result;
  }
  private void merge(int uParent, int vParent, Set<String>[] tempResult, List<List<String>> accounts, Map<String, Integer> map) {
    if (uParent == vParent) {
      return;
    }
    for (String key : map.keySet()) {
      if (map.get(key).equals(uParent)) {
        map.put(key, vParent);
      }
    }
    tempResult[vParent].addAll(tempResult[uParent]);
    tempResult[uParent] = null;
    return;
  }
}
