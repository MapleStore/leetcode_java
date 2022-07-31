package darren.gong.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FindShortestPath_1778 {
    interface GridMaster {
        boolean canMove(char direction);
        void move(char direction);
        boolean isTarget();
    }
    public static void main(String[] args) {
        FindShortestPath_1778 findShortestPath_1778 = new FindShortestPath_1778();
    }
    private final Map<Character, int[]> directions = new HashMap<>();
    boolean hasTarget = false;
    private GridMaster master;
    private boolean[][] visited = new boolean[1002][1002];
    private final char[] lastDirectionMap = new char[26];
    public int findShortestPath(GridMaster master) {
        int[][] grid = new int[1002][1002];
        this.master = master;
        lastDirectionMap['D'-'A'] = 'U';
        lastDirectionMap['U'-'A'] = 'D';
        lastDirectionMap['L'-'A'] = 'R';
        lastDirectionMap['R'-'A'] = 'L';
        directions.put('U', new int[]{-1, 0});
        directions.put('D', new int[]{1, 0});
        directions.put('L', new int[]{0, -1});
        directions.put('R', new int[]{0, 1});
        // -1起点 0不可通行 1可通行 2终点
        int[] startPos = new int[]{500, 500};
        grid[startPos[0]][startPos[1]] = -1;
        visited[startPos[0]][startPos[1]] = true;

        dfs(startPos[0], startPos[1], 'Z', grid);
        if (!hasTarget) {
            return -1;
        }
        visited = new boolean[1002][1002];
        return bfs(startPos[0], startPos[1], grid);
    }
    private void dfs(int currentX, int currentY, char lastDirection, int[][] grid) {
        if (master.isTarget()) {
            grid[currentX][currentY] = 2;
            hasTarget = true;
        }
        for (Map.Entry<Character, int[]> entry : directions.entrySet()) {
            char directionChar = entry.getKey();
            int[] direction = entry.getValue();
            int nextX = currentX+direction[0];
            int nextY = currentY+direction[1];
            if (!visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                if (master.canMove(directionChar)) {
                    grid[nextX][nextY] = 1;
                    master.move(directionChar);
                    dfs(nextX, nextY, lastDirectionMap[directionChar-'A'], grid);
                }
            }
        }
        if (lastDirection != 'Z') {
            master.move(lastDirection);
        }
    }

    private int bfs(int startX, int startY, int[][] grid) {
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int result = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    int nextX = current[0]+direction[0];
                    int nextY = current[1]+direction[1];
                    if (visited[nextX][nextY] || grid[nextX][nextY] == 0) {
                        continue;
                    }
                    if (grid[nextX][nextY] == 2) {
                        return result;
                    }
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
            result++;
        }
        return -1;
    }
}
