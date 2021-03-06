public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<Integer>();
    if(n <= 0) {
        return res;
    }
    boolean[] cols = new boolean[n]; // columns |
    boolean[] diagonal1 = new boolean[n*2]; // diagonal \
    boolean[] diagonal2 = new boolean[n*2]; // diagonal /
    helper(n, res, temp, cols, diagonal1, diagonal2);
    return res;
}

private void helper(int n, List<List<String>> res, List<Integer> temp, boolean[] cols, boolean[] d1, boolean[] d2) {
    if(temp.size() == n) {
        res.add(drawMap(temp));
        return;
    }
    int row = temp.size();
    for(int col = 0; col < n; col++) {
        int id1 = row - col + n;
        int id2 = row + col;
        if(cols[col] || d1[id1] || d2[id2]) {
            continue;
        }
        cols[col] = true; d1[id1] = true; d2[id2] = true;
        temp.add(col);
        helper(n, res, temp, cols, d1, d2);
        temp.remove(temp.size()-1);
        cols[col] = false; d1[id1] = false; d2[id2] = false;
    }
}

private List<String> drawMap(List<Integer> temp) {
    List<String> res = new ArrayList<String>();
    for(int i = 0; i < temp.size(); i++) {
        int col = temp.get(i);
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < temp.size(); j++) {
            if(j == col) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        res.add(sb.toString());
    }
    return res;
}
