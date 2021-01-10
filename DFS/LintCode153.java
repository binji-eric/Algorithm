// Given an array num and a number target. 
// Find all unique combinations in num where the numbers sum to target.
// Each number in num can only be used once in one combination.

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
            // 防止重复，如果相邻的相等，不允许跳过取值
            // 比如a1a2a3, 需要两个a，只取a1a2, a1a3, a2a3不符合条件
            // 假设nums=[2,2,2], target = 4, 
            
            // startIndex = 0, i = 0 -> startIndex = 1, i = 1, -> startIndex = 2, 将(a1a2)加入res
            //                                          i = 2,  continie, skip(a1a3)
            //                 i = 1, continue, skip(a2a3)

            if(i > startIndex && num[i] == num[i-1]) {
                continue;
            }
            temp.add(num[i]);
            dfs(num, i + 1, temp, remainTarget - num[i]);
            temp.remove(temp.size() - 1);
        }
    }
}