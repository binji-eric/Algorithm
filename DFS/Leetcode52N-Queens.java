class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        if(n <= 1) {
            return n;
        }
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2*n]; // diagonal \
        boolean[] d2 = new boolean [2*n]; // diagonal /
        helper(0, n, cols, d1, d2);
        return count;
    }
    
    private void helper(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        if(row == n) {
            count++;
            return;
        }
        for(int col = 0; col < n; col++) {
            int id1 = row - col + n;
            int id2 = row + col;
            if(cols[col] || d1[id1] || d2[id2]) {
                continue;
            }
            cols[col] = true; d1[id1] = true; d2[id2] = true;
            helper(row+1, n, cols, d1, d2);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
        }
    }
}