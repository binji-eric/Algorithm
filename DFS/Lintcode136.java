public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if(s == null) {
           return res;
        }
        dfs(s, 0, new ArrayList<String>(), res);
        return res;
    }
    
    private void dfs(String s, int startIndex, List<String> temp, List<List<String>> res) {
        if(startIndex == s.length()) {
            res.add(new ArrayList<String>(temp));
            return;
        }
        for(int i = startIndex; i < s.length(); i++) {
            String newStr = s.substring(startIndex, i+1);
            if(!isPalidrome(newStr)) {
               continue;
            }
            temp.add(newStr);
            dfs(s, i+1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
    
    private boolean isPalidrome(String str) {
        for(int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
}