public String longestPalindrome(String s) {
    if(s == null || s.length() <= 1)
        return s;
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    for(int i = 0; i<n; i++){
        dp[i][i] = true;
    }
    int left = 0, right = 0;
    for(int i = n-2; i>=0; i-- ){
        for(int j= i+1; j<n; j++){
            dp[i][j] = s.charAt(i) == s.charAt(j) && ((j-i <= 2)||dp[i+1][j-1]);
            if(dp[i][j]==true && j-i>right -left){
                left =i;
                right =j;
            }
        }
    }
    return s.substring(left, right+1);   
}