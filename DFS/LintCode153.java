public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        res = new ArrayList<>();
        if(num == null) {
            return res;
        }
        Arrays.sort(num);
        List<Integer> temp = new ArrayList<Integer>();
        dfs(num, 0, temp, target);
        return res;
    }
    
    private void dfs(int[] num, int startIndex, List<Integer> temp, int remainTarget) {
        if(remainTarget < 0) {
            return;
        }
        if(remainTarget == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        // recursion
        for(int i = startIndex; i < num.length; i++) {
            if(i > startIndex && num[i] == num[i-1]) {
                continue;
            }
            temp.add(num[i]);
            dfs(num, i + 1, temp, remainTarget - num[i]);
            temp.remove(temp.size() - 1);
        }
    }
}