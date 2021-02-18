// Return the length of the shortest such clear path from top-left to bottom-right.  
// If such a path does not exist, return -1.



class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        // 8个方向
        int[] directionX = {0, 0, 1, -1, 1, -1, 1, -1};
        int[] directionY = {-1, 1, 0, 0, 1, -1, -1, 1};
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            return -1;
        }
        LinkedList<int[]> que = new LinkedList<int[]>();
        boolean[][] visited = new boolean[m][n];
        que.offer(new int[]{0, 0});
        visited[0][0] = true;
        int step = 1;
        while(!que.isEmpty()) {
            int size = que.size();
            while(size > 0) {
                int[] node = que.poll();
                if(node[0] == m-1 && node[1] == n-1) {
                    return step;
                }
                size--;
                for(int i = 0; i < directionX.length; i++) {
                    int x = node[0] + directionX[i];
                    int y = node[1] + directionY[i];
                    if(x < 0 || x>=m || y < 0 || y>= n || grid[x][y] == 1 || visited[x][y]) {
                        continue;
                    }
                    que.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            step++;
        }
        return -1;
    }
}