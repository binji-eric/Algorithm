class Solution {
    // method1 O(n^2)
    public boolean checkSubarraySum(int[] nums, int k) {
        // nums[index] represent the num from 0 to index
        if(nums == null || nums.length < 2 ){
            return false;
        }
        int[] sum = new int[nums.length+1];
        for(int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        for(int t = 2; t <= nums.length; t++) {
            for(int i = 0; i <= nums.length - t ; i++) {
                int total = sum[i+t] - sum[i];
                if(k != 0 && total % k == 0 || k == 0 && total == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    // method2 O(n)
     public boolean checkSubarraySum(int[] nums, int k) {
        // nums[index] represent the num from 0 to index
        if(nums == null || nums.length < 2 ){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
         int prevSum = 0;
         for(int i = 0; i < nums.length; i++) {
             prevSum += nums[i];
             if(k != 0) {
                 prevSum = prevSum % k;
             }
             if(map.containsKey(prevSum)) {
                 // if requirements are satisfied, it means the sum from （map.get(prevSum)）to i is multiple of k
                 if(i - map.get(prevSum) > 1) {
                     return true;
                 }
             } else {
                 map.put(prevSum, i);
             }
         }
        return false;
    }
}