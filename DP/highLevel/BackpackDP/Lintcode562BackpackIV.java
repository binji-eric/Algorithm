// Given an integer array nums[] which contains n unique positive numbers,
// num[i] indicate the size of ith item. 
// An integer target denotes the size of backpack. 
// Find the number of ways to fill the backpack.
// Each item may be chosen unlimited number of times

public int backPackIV(int[] nums, int target) {
    // write your code here
    if(nums == null || nums.length == 0) {
        return 0;
    }
    int len = nums.length;
    int[][] dp = new int[len+1][target+1];
    dp[0][0] = 1;
    for(int i = 1; i <= len; i++) {
        for(int j = 0; j <= target; j++) {
            int k = 0;
            // k = 0时，dp[i][j] = dp[i-1][j];
            // k = 1+时，dp[i][j] += dp[i-1][j-total] total = nums[i-1]*k
            while(k*nums[i-1] <= j) {
                dp[i][j] += dp[i-1][j-nums[i-1]*k];
                k++;
            }
        }
    }
    return dp[len][target];
}