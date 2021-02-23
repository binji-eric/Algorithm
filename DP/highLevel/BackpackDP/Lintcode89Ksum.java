// Given n distinct positive integers, 
// integer k (k <= n) and a number target.
// Find k numbers where sum is target 
// Calculate how many solutions there are?

public int kSum(int[] A, int k, int target) {
    // write your code here
    if(A == null || A.length == 0) {
        return 0;
    }
    int n = A.length;
    int[][][] f = new int[n + 1][k + 1][target + 1];
    // 可选项为i个，取0个数，target为0时的，可选的方法数量
    for (int i = 0; i < n + 1; i++) {
        f[i][0][0] = 1;
    }
    for (int i = 1; i <= n; i++) {
        // 选择项不能超过i
        for (int j = 1; j <= k && j <= i; j++) {
            for (int t = 1; t <= target; t++) {
                // 背包的剩余是否可以装下A[i-1]
                if (t >= A[i - 1]) {
                    // 不选择A[i-1] 和 选择A[i-1]
                    f[i][j][t] = f[i - 1][j][t] + f[i - 1][j - 1][t - A[i - 1]];
                } else {
                    // 不选择A[i-1] 
                    f[i][j][t] = f[i - 1][j][t];
                }
            } // for t
        } // for j
    } // for i
    return f[n][k][target];
}