// Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

// A region is captured by flipping all 'O's into 'X's in that surrounded region.



public void solve(char[][] board) {
    if(board == null || board.length == 0||board[0] == null || board[0].length == 0)
        return;
    int row = board.length;
    int col = board[0].length;
    // 从边缘出来，将O反转成*，内部的O保持不变
    for(int i = 0; i<row; i++){
        // 左右两端
        if(board[i][0] == 'O')
            dfs(i, 0, board);
        if(board[i][col-1] == 'O')
            dfs(i, col-1, board);
    }
    for(int j = 0; j<col; j++){
        // 上下两端
        if(board[0][j] == 'O')
            dfs(0, j, board);
        if(board[row-1][j] =='O')
            dfs(row-1, j, board);
    }
    
    // 开始翻转, 将*反转成O, O反转成X
    for(int i =0; i<row; i++){
        for(int j =0; j<col ;j++)
            if(board[i][j] == '*')
                board[i][j] = 'O';
            else if(board[i][j] == 'O')
                board[i][j] = 'X';
    }
      
}

public void dfs(int i, int j, char[][] board){
    if(i<0 || j< 0|| i>board.length-1 || j>board[0].length-1)
        return;
    if(board[i][j] == 'X' || board[i][j] == '*')
        return;
    int row = board.length;
    int col = board[0].length;
    if(board[i][j] == 'O')
        board[i][j] = '*';
    dfs(i-1, j, board);
    dfs(i+1, j, board);
    dfs(i, j-1, board);
    dfs(i, j+1, board);
    
}
