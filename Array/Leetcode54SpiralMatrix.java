public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<Integer>();
    if(matrix == null || matrix.length == 0) {
        return res;
    }
    int row = matrix.length, col = matrix[0].length, step = 0;
    while(row > step*2 && col > step*2) {
        res.addAll(helper(matrix, row, col, step));
        step++;
    }
    return res;
}

public List<Integer> helper(int[][] matrix, int row, int col, int step) {
    int endX = col - 1 - step, endY = row - 1 - step;
    List<Integer> temp = new ArrayList<Integer>();
    // from left to right
    for(int i = step; i <= endX; i++) {
        temp.add(matrix[step][i]);
    }
    // form top to bottom
    for(int j = step + 1; j <= endY; j++) {
        temp.add(matrix[j][endX]);
    }
    // from right to left
    for(int i = endX - 1; i >= step && endY > step; i--) {
        temp.add(matrix[endY][i]);
    }
    // from bottom to top
    for(int j = endY - 1; j > step && endX > step; j--) {
        temp.add(matrix[j][step]);
    }
    return temp;
}