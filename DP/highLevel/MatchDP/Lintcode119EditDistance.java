// Given two words word1 and word2, find the minimum number of steps 
// required to convert word1 to word2. (each operation is counted as 1 step.)

// You have the following 3 operations permitted on a word:

// Insert a character
// Delete a character
// Replace a character

public int minDistance(String word1, String word2) {
    // write your code here
    if(word1 == null || word2 == null) {
        return 0;
    }
    int lenA = word1.length(), lenB = word2.length();
    int[][] dp = new int[lenA+1][lenB+1];
    // 如果word2长度是0，从word1到word2需要的距离
    for(int i = 0; i <= lenA; i++) {
        dp[i][0] = i;
    }
    // 如果word1长度是0，从word2到word1需要的距离
    for(int j = 0; j <= lenB; j++) {
        dp[0][j] = j;
    }
    for(int i = 1; i <= lenA; i++) {
        for(int j = 1; j <= lenB; j++) {
            if(word1.charAt(i-1) == word2.charAt(j-1)) {
                // 相等时，直接匹配
                dp[i][j] = dp[i-1][j-1];
            } else {
                // 不相等时，add ，delete 或者 直接relpace
                dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
            }
        }
    }
    return dp[lenA][lenB];
}