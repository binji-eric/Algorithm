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
        res.add(new ArrayList<Integer>(temp));
        for(int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, i + 1, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}