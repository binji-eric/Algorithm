// Given an integer array nums, return the length of the longest strictly increasing subsequence.

// A subsequence is a sequence that can be derived from an array 
// by deleting some or no elements without changing the order of the remaining elements. 
// For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

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
            // binarySearch(object[ ], int fromIndex, int endIndex, object key);
            // [1] 搜索值不是数组元素，且在数组范围内，从1开始计数，得“ - 插入点索引值”；
            // [2] 搜索值是数组元素，从0开始计数，得搜索值的索引值；
            // [3] 搜索值不是数组元素，且大于数组内元素，索引值为 – (length + 1);
            // [4] 搜索值不是数组元素，且小于数组内元素，索引值为 – 1。
            int i = Arrays.binarySearch(dp, 0, len, num);
            if(i < 0) {
                i = -(i+1);
            }
            // 在这个过程中，插入元素如果中间，是取代。这样中间元素会减小，为以后插入延长提供机会， LIS不变
            // 插入最后面，是增加，这时LIS会变大。
            dp[i] = num;
            if(i == len) {
                len++;
            }
        }
        return len;
    }
}