// Given an integer array, adjust each integers so that 
// the difference of every adjacent integers are not greater than a given number target.

// If the array before adjustment is A, the array after adjustment is B, 
// you should minimize the sum of |A[i]-B[i]|

public int MinAdjustmentCost(List<Integer> A, int target) {
    // write your code here
    if(A == null || A.size() == 0) {
        return 0;
    }
    int size = A.size();
    // f[i][v] 前i个数，第i个数调整为v，满足相邻两数<=target，所需要的最小代价
    int[][] dp = new int[size][101];
    for(int i = 0; i <= 100; i++) {
        dp[0][i] = Math.abs(A.get(0) - i);;
    }
    // 初始化为最大值
    for(int i = 1; i < size; i++) {
        for(int j = 0; j <= 100; j++) {
            dp[i][j] = Integer.MAX_VALUE;
        }
    }
    for(int i = 1; i < size; i++) {
        int oriVal = A.get(i);
        for(int k = 0; k <= 100; k++) {
            if(dp[i-1][k] != Integer.MAX_VALUE) {
                int min = Integer.MAX_VALUE;
                // 在位置i，调整后的取值范围，根据前文中k值决定，浮动范围为k+-target, 受到影响的是dp[i][t]
                for(int t = Math.max(1, k-target); t <= Math.min(100, k+target); t++) {
                     dp[i][t] = Math.min( dp[i][t], dp[i-1][k] + Math.abs(t-oriVal));
                }
            }
        }
    }
    int minRes = Integer.MAX_VALUE;
    for(int i = 0; i<= 100; i++) {
        if(dp[size-1][i] < minRes)
            minRes = dp[size-1][i];
    }
    return minRes;
}