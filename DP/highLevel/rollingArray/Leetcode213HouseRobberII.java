// All houses at this place are arranged in a circle.
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        else if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        // 只是打劫从0~len-2
        int[] memo = new int[3];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for(int i =2; i< nums.length -1; i++)
            memo[i%3] = Math.max(memo[(i-2)%3]+nums[i], memo[(i-1)%3]);
        // 只是打劫从1~len-1
        int[] memo1 = new int[3];
        memo1[1] = nums[1];
        memo1[2] = Math.max(nums[1], nums[2]);
        for(int i=3; i<nums.length; i++)
            memo1[i%3] = Math.max(memo1[(i-2)%3]+nums[i], memo1[(i-1)%3]);
        
        return Math.max(memo[(nums.length-2)%3],memo1[(nums.length-1)%3]);
    }
}


// 老方法，浪费存储
public int rob(int[] nums) {
    if(nums == null || nums.length == 0)
        return 0;
    if(nums.length == 1)
        return nums[0];
    else if(nums.length == 2)
        return Math.max(nums[0], nums[1]);
    // 只是打劫从0~len-2
    int[] memo = new int[nums.length];
    memo[0] = nums[0];
    memo[1] = Math.max(nums[0], nums[1]);
    for(int i =2; i< nums.length -1; i++)
        memo[i] = Math.max(memo[i-2]+nums[i], memo[i-1]);

     // 只是打劫从1~len-1
    int[] memo1 = new int[nums.length];
    memo1[1] = nums[1];
    memo1[2] = Math.max(nums[1], nums[2]);
    for(int i=3; i<nums.length; i++)
        memo1[i] = Math.max(memo1[i-2]+nums[i], memo1[i-1]);
    
    return Math.max(memo[nums.length-2],memo1[nums.length-1]);
}