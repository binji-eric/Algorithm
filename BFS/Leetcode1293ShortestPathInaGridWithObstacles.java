// Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle). 
// In one step, you can move up, down, left or right from and to an empty cell.

// Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m-1, n-1) 
// given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

class Solution {
    public int shortestPath(int[][] grid, int k) {
        if(grid == null || grid.length == 0 || grid[0] == null) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        // 如果k满足条件，直接从接近对角线的路径返回就可以
        if(k > m+n-2) {
            return m+n-2;
        }
        int[][] times = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(times[i], Integer.MAX_VALUE);
        }
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        times[0][0] = 0;
        int step = 0;
        int[] directionX = {0,-1, 1, 0};
        int[] directionY = {-1, 0, 0, 1};
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int[] node = queue.poll();
                // 递归出口
                if(node[0] == m-1 && node[1] == n-1) {
                   return step;
                }
                // 从node -> (x, y)
                for(int i = 0; i < 4; i++) {
                    int x = node[0] + directionX[i];
                    int y = node[1] + directionY[i];
                    if(x <0 || x>=m || y < 0 || y>= n) {
                        continue;
                    }
                    if(grid[x][y] == 0) {
                        if(times[node[0]][node[1]] < times[x][y]) {
                            times[x][y] = times[node[0]][node[1]];
                            queue.offer(new int[]{x, y});
                        }
                    // 存在障碍
                    } else {
                        // 克服了障碍, 并且消除障碍的总数不超出, 说明该路径是备选项
                        if(times[node[0]][node[1]] + 1 < times[x][y] && times[node[0]][node[1]] < k) {
                            times[x][y] = times[node[0]][node[1]] + 1;
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
                size--;
            }
            step++;
        }
        return -1;
        
    }
}