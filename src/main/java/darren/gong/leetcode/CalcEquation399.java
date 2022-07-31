package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalcEquation399 {
    public static void main(String[] args) {
        CalcEquation399 calcEquation399 = new CalcEquation399();
        List<List<String>> lists = new ArrayList<>();
        List<String> list1 = new ArrayList(Arrays.asList(new String[]{"x1","x2"}));
        List<String> list2 = new ArrayList(Arrays.asList(new String[]{"x2","x3"}));
        List<String> list3 = new ArrayList(Arrays.asList(new String[]{"x1","x4"}));
        List<String> list4 = new ArrayList(Arrays.asList(new String[]{"x2","x5"}));
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        calcEquation399.calcEquation(lists, new double[]{3.0,0.5,3.4,5.6}, new ArrayList<>());
    }
    private Map<String, String> stringToParent = new HashMap<>();
    private Map<String, Double> stringToValue = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> oneEquation = equations.get(i);
            String u = oneEquation.get(0);
            String v = oneEquation.get(1);
            if (!stringToParent.containsKey(u)) {
                stringToParent.put(u, u);
                stringToValue.put(u, 1d);
            }
            if (!stringToParent.containsKey(v)) {
                stringToParent.put(v, v);
                stringToValue.put(v, 1d);
            }

            String uParent = stringToParent.get(u);
            String vParent = stringToParent.get(v);
            if (uParent.equals(vParent)) {
                continue;
            }
            union(u, v, values[i]);
        }

        double[] result = new double[queries.size()];
        int index = 0;
        for (List<String> query : queries) {
            String u = query.get(0);
            String v = query.get(1);
            if (!stringToParent.containsKey(u) || !stringToParent.containsKey(v) || !stringToParent.getOrDefault(u, u).equals(stringToParent.getOrDefault(v, v))) {
                result[index++] = -1.0;
            } else {
                result[index++] = stringToValue.get(u)/stringToValue.get(v);
            }
        }
        return result;
    }
    // u被除数, v除数, value: u/v
    private void union(String u, String v, double value) {
        String uParent = stringToParent.getOrDefault(u, u);
        String vParent = stringToParent.getOrDefault(v, v);
        if (uParent.equals(vParent)) {
            return;
        }
        double uDivideParent = stringToValue.get(u);
        double vDivideParent = stringToValue.get(v);
        for (String key : stringToParent.keySet()) {
            if (stringToParent.get(key).equals(uParent)) {
                stringToParent.put(key, vParent);
                // key/uParent = stringToValue.get(key)
                // u/uParent = stringToValue.get(u)
                // u/v = value
                // v/vParent = stringToValue.get(v)
                stringToValue.put(key, stringToValue.get(key)/uDivideParent*value*vDivideParent);
            }
        }
    }

}
