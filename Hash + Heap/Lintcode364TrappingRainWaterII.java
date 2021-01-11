class Cell {
    public int x, y, h;
    public Cell(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        // write your code here
        // 堆用来维护最小的灌水高度
        int[] dirX = {0, -1, 1, 0};
        int[] dirY = {-1, 0, 0, 1};
        if(heights == null) {
            return 0;
        }
        int m = heights.length, n = heights[0].length, res = 0;
        if(m <= 2 || n <=2) {
            return 0;
        }
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
            public int compare(Cell a, Cell b) {
                return a.h - b.h;
            }
        });
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heights[i][0]));
            pq.offer(new Cell(i, n-1, heights[i][n-1]));
            visited[i][0] = true;
            visited[i][n-1] = true;
        }
        for(int i = 1; i < n-1; i++) {
            pq.offer(new Cell(0, i, heights[0][i]));
            pq.offer(new Cell(m-1, i, heights[m-1][i]));
            visited[0][i] = true;
            visited[m-1][i] = true;
        }
        
        while(!pq.isEmpty()) {
            Cell temp = pq.poll();
            for(int i = 0; i < dirY.length; i++) {
                int newX = temp.x + dirX[i];
                int newY = temp.y + dirY[i];
                if(newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]) {
                    continue;
                }
                visited[newX][newY] = true;
                if(heights[newX][newY] > temp.h) {
                    pq.offer(new Cell(newX, newY, heights[newX][newY]));
                } else {
                    res += temp.h - heights[newX][newY];
                    pq.offer(new Cell(newX, newY, temp.h));
                }
            }
        }
        return res;
    }
}