public int backPack(int m, int[] A) {
    // write your code here 
    // if(A == null || A.length == 0) {
    //     return 0;
    // }
    // int len = A.length;
    // int[][] dp = new int[len+1][m+1];
    // for(int i = 1; i <= len; i++) {
    //     for(int j = 1; j <= m; j++) {
    //         if(A[i-1] > j) {
    //             // don't choose A[i-1] because size of backpack is smaller than A[i-1]
    //             dp[i][j] = dp[i-1][j];
    //         } else {
    //             // chooese max between  two options
    //             dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i-1]] + A[i-1]);
    //         }
    //     }
    // }
    // return dp[len][m];
    if(A == null || A.length == 0) {
        return 0;
    }
    int len = A.length;
    int[][] dp = new int[2][m+1];
    for(int i = 1; i <= len; i++) {
        for(int j = 1; j <= m; j++) {
            if(A[i-1] > j) {
                // don't choose A[i-1] because size of backpack is smaller than A[i-1]
                dp[i%2][j] = dp[(i-1)%2][j];
            } else {
                // chooese max between  two options
                dp[i%2][j] = Math.max(dp[(i-1)%2][j], dp[(i-1)%2][j-A[i-1]] + A[i-1]);
            }
        }
    }
    return dp[len%2][m];
}