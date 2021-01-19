// Given an integer array, 
// find a subarray where the sum of numbers is zero. 
// Your code should return the index of the first number 
// and the index of the last number.

public List<Integer> subarraySum(int[] nums) {
    // write your code here
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    List<Integer> res = new ArrayList<Integer>();
    if(nums == null) {
        return res;
    } 
    map.put(0, -1);
    int count = 0;
    for(int i = 0; i < nums.length; i++) {
        count += nums[i];
        if(map.containsKey(count)) {
            res.add(map.get(count)+1);
            res.add(i);
            return res;
        }
        map.put(count, i);
    }
    return res;
}