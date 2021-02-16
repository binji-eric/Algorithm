// Given a list of numbers, return all possible permutations.
// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

// 空间复杂度 空间复杂度：O(N!)  共有N!个全排列，故需要保存N!个解
// 搜索的时间复杂度：O(答案总数 * 构造每个答案的时间)
// 举例：Subsets问题，求所有的子集。子集个数一共 2^n，每个集合的平均长度是 O(n) 的，
// 所以时间复杂度为 O(n * 2^n)，同理 Permutations 问题的时间复杂度为：O(n * n!)

// public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);
        return results;
    }
    
    private void dfs(int[] nums,
                     boolean[] visited,
                     List<Integer> permutation,
                     List<List<Integer>> results) {
        // 和nums长度相等，已经拼接成合法的排列
        if (nums.length == permutation.size()) {
            // 新建new ArrayList<Integer>()，否则存储的是同一个list的引用
            results.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // visited, then skip
            if (visited[i]) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            // backtrack
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}