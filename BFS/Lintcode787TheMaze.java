public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    class MyNode {
        int x, y;
        public MyNode(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } 
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if(maze == null || maze.length == 0 || maze[0] == null) {
            return false;
        }
        LinkedList<MyNode> que = new LinkedList<MyNode>();
        int[] directionX = {0, -1, 1, 0};
        int[] directionY = {-1, 0, 0 ,1};
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        que.offer(new MyNode(start[0], start[1]));
        visited[start[0]][start[1]] = true;
        while(!que.isEmpty()) {
            MyNode temp = que.poll();
            if(temp.x == destination[0] && temp.y == destination[1]) {
                return true;
            }
            for(int i = 0; i < 4; i++) {
                // 碰到1或者墙为止
                int x = temp.x, y = temp.y;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += directionX[i]; 
                    y += directionY[i];
                }
                // 回退一步
                x -= directionX[i]; y -= directionY[i];
                if(!visited[x][y]){
                    visited[x][y] = true;
                    que.offer(new MyNode(x, y));
                }

            }
        }
        return false;
    }
}