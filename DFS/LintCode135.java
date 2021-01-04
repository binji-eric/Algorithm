public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        // key points
        // 1, duplicate 2, target
        res = new ArrayList<>();
        if(candidates == null) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<Integer>();
        dfs(candidates, 0, temp, target);
        return res;
    }
    
    private void dfs(int[] candidates, int startIndex,  List<Integer> temp, int remainTarget) {
        if(remainTarget < 0) {
            return;
        }
        if(remainTarget == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        // 递归
        for(int i = startIndex; i < candidates.length; i++) {
            // skip duplicate candidate
            if(i != 0 && candidates[i] == candidates[i-1]) {
                continue;
            }
            temp.add(candidates[i]);
            dfs(candidates, i, temp, remainTarget - candidates[i]);
            temp.remove(temp.size() - 1);
        }
        
    }
}
