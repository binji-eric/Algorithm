// Given a set of distinct integers, 
// return all possible subsets.
// Input: [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]


// Subsets问题，求所有的子集。子集个数一共 2^n，每个集合的平均长度是 O(n) 的，
// 所以时间复杂度为 O(n * 2^n)
public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null){
            return res;
        }
        Arrays.sort(nums);
        ArrayList<Integer> temp = new ArrayList<>();
        helper(nums, 0, temp, res);
        return res;
    }
    
    private void helper(int[] nums, 
                        int startIndex, 
                        ArrayList<Integer> temp, 
                        List<List<Integer>> res) {
        // 遇到任何的中间结果，立即加入res
        res.add(new ArrayList<Integer>(temp));
        for(int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, i + 1, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}