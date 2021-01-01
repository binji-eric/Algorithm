class Solution {
    // O(n^2)
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1; i < len; i++) {
            for(int j = 0; j <i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
        }
        int max = 1;
        for(int value: dp) {
            max = Math.max(max, value);
        }
        return max;
    }
}