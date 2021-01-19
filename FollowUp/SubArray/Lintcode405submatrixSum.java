public int[][] submatrixSum(int[][] matrix) {
    // write your code here
    int[][] res = new int[2][2];
    if(matrix == null || matrix.length == 0 || matrix[0] == null) {
        return res;
    }
    int m = matrix.length, n = matrix[0].length;
    int[][] sum = new int[m+1][n+1];
    for(int i = 0; i <= m; i++) {
        sum[i][0] = 0;
    }
    for(int j = 0; j <= n; j++) {
        sum[0][j] = 0;
    }
    for(int i = 1; i <= m; i++) {
        for(int j = 1; j <= n; j++) {
            sum[i][j] = sum[i-1][j] + sum[i][j-1] + matrix[i-1][j-1] - sum[i-1][j-1];
        }
    }
    for(int l = 0; l < m; l++) {
        for(int r = l+1; r <= m; r++) {

            // 固定上下边界，左右滑动，利用subarray sumI的方法，每个竖条和相当于一个数
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i<= n; i++) {
                int diff = sum[r][i] - sum[l][i];
                if(map.containsKey(diff)) {
                    int colIndex = map.get(diff);
                    res[0][0] = l;
                    res[0][1] = colIndex;
                    res[1][0] = r-1;
                    res[1][1] = i-1;
                } else {
                    map.put(diff, i);
                }
            }
        }
    }
    return res;
}