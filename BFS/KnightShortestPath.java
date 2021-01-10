/**
 * descriptiont: Given a knight in a chessboard 
 * (a binary matrix with 0 as empty and 1 as barrier) with a source position, 
 * find the shortest path to a destination position, return the length of the route.
 * Return -1 if destination cannot be reached.

    https://www.jiuzhang.com/solutions/knight-shortest-path/
 */


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    public static final int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    public static final int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0
                || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        
        Queue<Point> queue = new ArrayDeque();
        Map<Integer, Integer> distance = new HashMap();
        
        int n = grid.length, m = grid[0].length;
        queue.offer(source);
        distance.put(source.x * m + source.y, 0);
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x == destination.x && point.y == destination.y) {
                return distance.get(point.x * m + point.y);
            }
            
            for (int i = 0; i < 8; i++) {
                int adjX = point.x + dx[i];
                int adjY = point.y + dy[i];
                if (!isValid(adjX, adjY, grid)) {
                    continue;
                }
                if (distance.containsKey(adjX * m + adjY)) {
                    continue;
                }
                // 下一步棋子的cost，并且将位置放置到队列中
                distance.put(adjX * m + adjY, distance.get(point.x * m + point.y) + 1);
                queue.offer(new Point(adjX, adjY));
            }
        }
        
        return -1;
    }
    
    private boolean isValid(int x, int y, boolean[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        return !grid[x][y];
    }
}