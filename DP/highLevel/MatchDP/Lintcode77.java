public int longestCommonSubsequence(String A, String B) {
    // write your code here
    if(A == null || B == null) {
        return 0;
    }
    int lenA = A.length(), lenB = B.length();
    int[][] dp = new int[2][lenB+1];
    for(int i = 0; i < lenA; i++) {
        for(int j = 0; j < lenB; j++) {
            if(A.charAt(i) == B.charAt(j)) {
                dp[(i+1)%2][j+1] = dp[i%2][j] + 1;
            } else {
                // A.charAt(i) != B.charAt(j), 
                dp[(i+1)%2][j+1] = Math.max(dp[(i+1)%2][j], dp[i%2][j+1]);
            }
        }
    }
    return dp[lenA%2][lenB];
}