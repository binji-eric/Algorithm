public class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here // write your code here
        if(n <= 0 || n == 3) {
            return false;
        } else if(n <= 2) {
            return true;
        } 

        boolean[] dp = new boolean[n+1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        dp[3] = false;
        for(int i = 4; i <= n; i++) {
            dp[i] = dp[i-2]&&dp[i-3] || dp[i-3]&&dp[i-4];
        }
        return dp[n];
    }
}