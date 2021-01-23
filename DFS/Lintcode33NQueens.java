public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if(n <= 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
        helper(n,  temp, res);
        return res;
    }
    
    public void helper(int n, List<Integer> temp, List<List<String>> res) {
        if(temp.size() == n) {
            res.add(drawBoard(temp));
            return;
        }
        for(int index = 0; index < n; index++) {
            if(!isValid(temp, index)) {
                continue;
            }
            temp.add(index);
            helper(n, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
    
    public List<String> drawBoard(List<Integer> temp) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < temp.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < temp.size(); j++) {
                if(j == temp.get(i)) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
    
    public boolean isValid(List<Integer> temp, int col) {
        int row = temp.size();
        for(int rowIndex = 0; rowIndex < row; rowIndex++) {
            if(temp.get(rowIndex) == col) {
                return false;
            } else if(rowIndex + temp.get(rowIndex) == col + row) {
                return false;
            } else if(rowIndex - temp.get(rowIndex) == row - col) {
                return false;
            }
        }
        return true;
    }
    
}