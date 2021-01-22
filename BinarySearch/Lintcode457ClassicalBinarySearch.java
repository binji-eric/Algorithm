// Find any position of a target number in a sorted array. 
// Return -1 if target does not exist.

public int findPosition(int[] nums, int target) {
    // write your code here
    if(nums == null || nums.length == 0) {
        return -1;
    }
     int start = 0, end = nums.length - 1;
    while(start + 1 < end) {
        int mid = start + (end - start)/2;
        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] > target) {
            end = mid - 1;
        } else if(nums[mid] < target) {
            start = mid + 1;
        }
    }
    if(nums[start] == target) {
        return start;
    } else if(nums[end] == target) {
        return end;
    }
    return -1;
}