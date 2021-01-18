private int search(int[] nums, int left, int right, int[][] dp, boolean[][] visited) {
    if(left > right) {
        return 0;
    } 
    if(visited[left][right]) {
        return dp[left][right];
    }
    int max = 0;
    for(int k = left; k <= right; k++) {
        int midVal = nums[left-1]*nums[k]*nums[right+1];
        int leftVal = search(nums, left, k-1, dp, visited);
        int rightVal = search(nums, k+1, right, dp, visited);
        max = Math.max(max, midVal + leftVal + rightVal);
    }
    dp[left][right] = max;
    visited[left][right] = true;
    return dp[left][right];
}
public int maxCoins(int[] nums) {
    // write your code here
    if(nums == null || nums.length == 0) {
        return 0;
    }
    int len = nums.length;
    boolean[][] visited = new boolean[len+2][len+2];
    int[][] dp = new int[len+2][len+2];
    int[] newNums = new int[len+2];
    for(int i = 1; i <= len; i++) {
        newNums[i] = nums[i-1];
    } 
    // 两端的气球设为1，有利于处理边界问题
    newNums[0] = 1;
    newNums[len+1] = 1;
    return search(newNums, 1, len, dp, visited);
}