public int maximalRectangle(char[][] matrix) {
    if(matrix == null || matrix.length == 0) {
        return 0;
    }
    int max = 0, row = matrix.length, col = matrix[0].length;
    LinkedList<Integer> stack = new LinkedList<Integer>();
    int[] heights = new int[col];
    stack.push(-1);
    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            // 对于每行的遍历，可以视作对于height的一遍操作, 相当于Leetcode84的复杂处理
            if(matrix[i][j] == '1') {
                heights[j] += 1;
            } else {
                heights[j] = 0;
            }
            while(stack.peek() != -1 && heights[stack.peek()] > heights[j]) {
                int high = heights[stack.pop()];
                max = Math.max(max, high*(j-stack.peek() - 1));
            }
            stack.push(j);
        }
        // 收尾工作
        while(stack.peek() != -1) {
            int high = heights[stack.pop()];
            max = Math.max(max, high*(col - stack.peek() - 1));
        }
    }
    return max;
}