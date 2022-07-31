package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CanFinish207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] classToPre = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            classToPre[i] = new ArrayList<Integer>(numCourses);
        }
        for (int[] oneClassToPre : prerequisites) {
            classToPre[oneClassToPre[0]].add(oneClassToPre[1]);
        }
        boolean[] canFinish = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(i, visited, canFinish, classToPre)) {
                return false;
            }
        }
        return true;
    }
    private boolean canFinish(int curClass, boolean[] visited, boolean[] canFinish, List<Integer>[] classToPre) {
        if (canFinish[curClass]) {
            return true;
        }
        if (visited[curClass]) {
            return false;
        }
        visited[curClass] = true;
        for (int nextClass : classToPre[curClass]) {
            if (!canFinish(nextClass, visited, canFinish, classToPre)) {
                return false;
            }
        }
        visited[curClass] = false;
        canFinish[curClass] = true;
        return true;
    }
}
