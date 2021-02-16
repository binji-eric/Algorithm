// Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

// The distance between two adjacent cells is 1.

class Solution {

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
			return matrix;
		int m = matrix.length, n = matrix[0].length;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				// 把0元素加入队列中，以备波及影响周围元素
				if (matrix[i][j] == 0)
					q.offer(new int[] { i, j });
				else
					// 设为最大值，方便求0元素影响值
					matrix[i][j] = Integer.MAX_VALUE;
			}
		// 上下左右
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (!q.isEmpty()) {
			int cell[] = q.poll();
			for (int[] d : dirs) {
				int row = cell[0] + d[0];
				int col = cell[1] + d[1];
				if (row < 0 || row >= m || col < 0 || col >= n)
					continue;
				// 上下左右取到的值
				int value = matrix[row][col];
				int tmp = matrix[cell[0]][cell[1]] + 1;
				// 如果value小，那说明之前已经更新过，不是max
				if (value <= tmp)
					continue;
				q.offer(new int[] { row, col });
				matrix[row][col] = tmp;
			}
		}
		return matrix;
    }
   
}