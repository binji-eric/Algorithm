// this problem cann't be solved by greedy algorithm
// to prove that point, this case [6, 4, 5, 6] is a great test case


// 从大到小做，先考虑最后一步的最小花费

private int search(int[] A, int left, int right, int[][] sum, boolean[][] visited, int[][] dp) {
    if(left >= right) {
        return 0;
    } else if(visited[left][right]) {
        return dp[left][right];
    }
    dp[left][right] = Integer.MAX_VALUE;
    for(int k = left; k < right; k++) {
        dp[left][right] = Math.min(dp[left][right], 
        search(A, left, k, sum, visited, dp) 
        + search(A, k+1, right, sum, visited, dp) 
        +  sum[left][right]);
    }
    visited[left][right] = true;
    return dp[left][right];
}

public int stoneGame(int[] A) {
    // write your code here
    if(A == null || A.length <= 1) {
        return 0;
    }
    int len = A.length;
    // dp[i][j] 表示把第i个到第j个合并在一起的最小花费
    int[][] dp = new int[len][len];
    boolean visited[][] = new boolean[len][len];
    int[][] sum = new int[len][len];
    // calculate sum 
    for(int i = 0; i < len; i++) {
        sum[i][i] = A[i];
        for(int j = i+1; j < len; j++) {
            sum[i][j] = sum[i][j-1] + A[j];
        }
    }
    return search(A, 0, len-1, sum, visited, dp);
}