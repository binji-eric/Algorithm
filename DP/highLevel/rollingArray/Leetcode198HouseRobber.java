// Each house has a certain amount of money stashed, 
// the only constraint stopping you from robbing each of them is that 
// adjacent houses have security system 
// 需要隔一偷一
class Solution {
    // method1, traditional method
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i = 1; i < len; i++) {
            if(i >= 2) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            } else {
                dp[i] = Math.max(dp[i-1], nums[i]);
            }
        }
        return dp[len-1];
    }
    // method2, use rolling array, save lots of memory space
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[3];
        dp[0] = nums[0];
        for(int i = 1; i < len; i++) {
            if(i >= 2) {
                dp[i%3] = Math.max(dp[(i-1)%3], dp[(i-2)%3] + nums[i]);
            } else {
                dp[i%3] = Math.max(dp[(i-1)%3], nums[i]);
            }
        }
        return dp[(len-1)%3];
    }
}