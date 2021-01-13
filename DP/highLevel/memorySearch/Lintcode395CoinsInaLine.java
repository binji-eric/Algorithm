public boolean firstWillWin(int[] values) {
    // write your code here
    if(values == null || values.length == 0) {
        return false;
    } else if(values.length <= 2) {
        return true;
    } else if(values.length == 3 && values[0] + values[1] > values[2]) {
        return true;
    }
    int sum = 0, len = values.length;
    for(int value: values) {
        sum += value;
    }
    int[] dp = new int[len+1];
    dp[0] = 0;
    dp[1] = values[len-1];
    dp[2] = values[len-1] + values[len-2];
    dp[3] = values[len-2] + values[len-3];
    for(int i = 4; i <=len; i++) {
        dp[i] = Math.max(Math.min(dp[i-2], dp[i-3]) + values[len-i], Math.min(dp[i-3], dp[i-4]) + values[len-i] + values[len-i+1]);
    }
    return dp[len]*2 > sum;
 }