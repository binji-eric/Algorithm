class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix[0].length < 1) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] == '0'? 0:  1;
        }
        for(int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0] == '0'? 0:  1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}

// method2: use rolling array

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix[0].length < 1) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        // 其实只是需要两行的数组，所以 m =2, for循环中所有的行元素都进行模2的操作
        int[][] dp = new int[2][n];
        int max = 0;
        for(int i = 0; i < m; i++) {
            // 初始化第一列的元素
            dp[i%2][0] = matrix[i][0] == '0'? 0:  1;
            max = Math.max(max, dp[i%2][0]);
            for(int j = 1; j < n; j++) {
                if(i > 0) {
                    if(matrix[i][j] == '0') {
                        dp[i%2][j] = 0;
                    } else {
                        dp[i%2][j] = Math.min(Math.min(dp[(i-1)%2][j], dp[(i-1)%2][j-1]), dp[i%2][j-1]) + 1;
                    }
                    // i == 0 时
                } else {
                      // 初始化第一行的元素
                     dp[i%2][j] = matrix[i][j] == '0'? 0:  1;
                }
                 max = Math.max(max, dp[i%2][j]);
            }
        }
        return max*max;
    }
}