// Given a collection of integers that might contain duplicates, nums, 
// return all possible subsets (the power set).


// Input: [1,2,2]
// Output:
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]


public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) {
            return results;
        }
        // key1 需要排序，这样使得相同的内容相邻
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void helper(int[] nums, 
                        int startIndex, 
                        List<Integer> temp, 
                        List<List<Integer>> results) {
        // key2 直接加入，[]也是其中一个子集，new ArrayList<>()进行深拷贝
        results.add(new ArrayList<Integer>(temp));
        for(int i = startIndex; i < nums.length; i++) {
            // key3 避免重复，i > startIndex 保证非起点状态时的相同, 
            // nums[i] == nums[i-1]相同的情况
            // 因为nums[i] == nums[i-1] && i = startIndex之前已经遍历过，并且放在res中
            if(i > startIndex && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            helper(nums, i + 1, temp, results);
            // key4 回溯法，删除刚刚加入的值
            temp.remove(temp.size()-1);
        }
    }
}