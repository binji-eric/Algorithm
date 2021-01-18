// There are n items and a backpack with size m. 
// Given array A representing the size of each item and 
// array V representing the value of each item.

public int backPackII(int m, int[] A, int[] V) {
    // write your code here
    if(A == null || V == null || A.length == 0 || A.length != V.length) {
        return 0;
    }
    int len = A.length;
    int[][] dp = new int[2][m+1];
    for(int i = 1; i <= len; i++) {
        for(int j = 0; j <= m; j++) {
            // exceed the size of backpack, skip i
            if(A[i-1] > j) {
                dp[i%2][j] = dp[(i-1)%2][j];
            } else {
                //  不能是f[i][j] = max(f[i-1][j], f[i][j-A[i-1]] + V[i-1]);
                // 上面式子不对，是因为f[i][j-A[i-1]] 可能将A[i-1]已经加入了
                //  f[i][j] = max(f[i-1][j], f[i-1][j-A[i-1]] + V[i-1]);
                dp[i%2][j] = Math.max(dp[(i-1)%2][j], dp[(i-1)%2][j-A[i-1]] + V[i-1]);
            }
        }
    }
    return dp[len%2][m];
}