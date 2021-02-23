// dp (from top to bottom), time complexity is O(n^2)
// Given a triangle array, return the minimum path sum from top to bottom.
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int m = triangle.size(), n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        // 三角形两侧的值，先确定
        for(int i = 1; i < m; i++) {
            // 左侧
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            // 右侧
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < i; j++) {
                // 每个节点，由左上节点 或者 右上节点 获得
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
        }
        int minPath = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(minPath > dp[m-1][i]) {
                minPath = dp[m-1][i];
            }
        }
        return minPath;
    }  
}


// dp(from bottom to top), time complexity is O(n^2)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int m = triangle.size(), n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
        for(int i = 0; i < triangle.get(m-1).size(); i++) {
            dp[m-1][i] = triangle.get(m-1).get(i);
        }
        for(int i = m-2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }  
}



// divide and conquer + memo, time complexity is O(n^2)
class Solution {
    private int[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.get(m-1).size();
        memo = new int[m][n];
        for(int[] temp: memo) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }
        helper(triangle, 0, 0);
        return memo[0][0];
    }
    
    private int helper(List<List<Integer>> triangle, int row, int col) {
        if(row == triangle.size()) {
            return 0;
        }
        if(memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }
        memo[row][col] = triangle.get(row).get(col) + Math.min(helper(triangle, row+1, col), helper(triangle, row+1, col+1));
        return memo[row][col];
    }
}

// dfs(Time Limit Exceeded), time complexity is 2^n
class Solution {
    private int minPath = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        helper(triangle, 0, 0, 0);
        return minPath;
    }
    
    private void helper(List<List<Integer>> triangle, int row, int col, int sum) {
        if(row == triangle.size()) {
            minPath = Math.min(minPath, sum);
            return;
        }
        helper(triangle, row+1, col, triangle.get(row).get(col) + sum);
        helper(triangle, row+1, col+1, triangle.get(row).get(col) + sum);
    }
}
