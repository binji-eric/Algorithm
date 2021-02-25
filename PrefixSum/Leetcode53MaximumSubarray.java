// Given an integer array nums, find the contiguous subarray 
// (containing at least one number) which has the largest sum and return its sum.

class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length, pre = nums[0], max = pre;
        for(int i = 1; i<len; i++) {
            int cur =  pre > 0? pre + nums[i]: nums[i];
            max = Math.max(max, cur);
            pre = cur;
        }
        return max;
    }
}