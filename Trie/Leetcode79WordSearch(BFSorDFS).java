public int[][] dir ={{0,1}, {0,-1}, {1,0}, {-1,0}};
public boolean exist(char[][] board, String word) {
    if(board == null || board[0].length == 0)
        return false;
    int m = board.length;
    int n = board[0].length;
    boolean[][] map = new boolean[m][n];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n ;j++){
            if(board[i][j] == word.charAt(0)){
                map[i][j] = true;
                if(backtracking(i,j,board, map, word, 1))
                    return true;
                map[i][j] =false;
            }
        }
    }
    return false;
}
public boolean backtracking(int x, int y, char[][] board, boolean[][] map, String word, int i){
    if(i == word.length())
        return true;
    for(int k = 0; k < dir.length; k++){
        int x1 = x+dir[k][0];
        int y1 = y+dir[k][1];
        if(x1>=0 && x1<board.length && y1>=0 &&y1<board[0].length &&map[x1][y1]==false){
            if(board[x1][y1] == word.charAt(i)){
                map[x1][y1] = true;
                if( backtracking(x1, y1, board, map, word, i+1))
                    return true;
                map[x1][y1] =false;
            }
        }
    }
    return false;
    
}
