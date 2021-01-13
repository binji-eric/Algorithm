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

    // binarySearch O(nlogn)
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        int len = 0;
        for(int num: nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if(i < 0) {
                i = -(i+1);
            }
            // 在这个过程中，插入元素如果中间，是取代。这样中间元素会减小，为以后插入延长提供机会
            // 插入最后面，是增加。
            dp[i] = num;
            if(i == len) {
                len++;
            }
        }
        return len;
    }
}