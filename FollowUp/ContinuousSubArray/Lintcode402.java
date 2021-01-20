public List<Integer> continuousSubarraySum(int[] A) {
    // write your code here
    List<Integer> res = new ArrayList<Integer>();
    if(A == null || A.length == 0) {
        return res;
    }
    int len = A.length;
    int[] dp = new int[len+1];
    int[] arr = new int[len+1];
    int max = Integer.MIN_VALUE;
    int startIndex = 0, endIndex = 0;
    for(int i = 1; i <= len; i++) {
       if(dp[i-1] < 0) {
           dp[i] = A[i-1];
           arr[i] = i-1;
       } else {
           dp[i] = dp[i-1] + A[i-1];
           arr[i] = arr[i-1];
       }
       if(dp[i] > max) {
           max = dp[i];
           startIndex = arr[i];
           endIndex = i-1;
       }
    }
    res.add(startIndex);
    res.add(endIndex);
    return res;
}

public List<Integer> continuousSubarraySum(int[] A) {
    // return res;
    List<Integer> result = new ArrayList<Integer>();
    result.add(0);
    result.add(0);

    int len = A.length;
    int start = 0, end = 0;
    int sum = 0;
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
        // sum < 0，从当前位置开始计数
        if (sum < 0) {
            sum = A[i];
            start = end = i;
        } else {
            // sum >= 0时，只更新end和sum，保持start
            sum += A[i];
            end = i;
        }
        if (sum > ans) {
            ans = sum;
            result.set(0, start);
            result.set(1, end);
        }
    }
    return result;
}