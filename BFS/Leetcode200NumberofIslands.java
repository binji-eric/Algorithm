/**
 *
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.
 */

// method1 BFS
class Solution {
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    markByBfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void markByBfs(char[][] grid, int i,int j) {
        int[] directionX = {0, -1, 1, 0};
        int[] directionY = {-1, 0, 0, 1};
        
        Queue<Coordinate> que = new LinkedList<>();
        que.offer(new Coordinate(i, j));
        grid[i][j] = '0';
        while(!que.isEmpty()) {
            Coordinate temp = que.poll();
            for(int k = 0; k < 4; k++) {
                Coordinate newNode = new Coordinate(temp.x + directionX[k], 
                                                    temp.y + directionY[k]);
                if(isValid(grid, newNode.x, newNode.y) && grid[newNode.x][newNode.y] == '1') {
                    grid[newNode.x][newNode.y] = '0';
                    que.offer(newNode);
                }
            }
        }
        
    }
    
    private boolean isValid(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i > m - 1 || j < 0 || j > n - 1 || grid[i][j] == '0') {
            return false;
        }
        return true;
    }
}

// method2 dfs
class Solution {
    private int n;
    private int m;
    
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }    
        return count;
    }
    
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
    }