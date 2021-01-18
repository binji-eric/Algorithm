public int numDistinct(String S, String T) {
    // write your code here
    if(S == null || T == null) {
        return 0;
    }
    int lenA = S.length(), lenB = T.length();
    //pd[i][j] T中前j的字符在S的前i字符出现的次数
    int[][] dp = new int[lenA+1][lenB+1];
    for(int i = 0; i <= lenA; i++) {
        // 从S中什么都不取，也算是一种方案
        dp[i][0] = 1;
    }
    for(int i = 1; i <= lenA; i++) {
        for(int j = 1; j <= lenB; j++) {
            // source != target at index i,j 
            if(S.charAt(i-1) != T.charAt(j-1)) {
                // 说明S新增的i没有新的可能性，所以要在新的i中找到是否与j匹配的字符
                // dp[i][j]的效果和dp[i-1][j]一样
                dp[i][j] = dp[i-1][j];
            } else {
                // 如果两个string的指定位置字符相等
                // 说明S新加的i带来了新的可能性，
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }
    }
    return dp[lenA][lenB];
}