// For a given sorted array (ascending order) and a target number, 
// find the first index of this number in O(log n) time complexity.

public int binarySearch(int[] nums, int target) {
    // write your code here
    int start = 0, end = nums.length - 1;
    while(start + 1 < end) {
        int mid = start + (end - start)/2;
        if(nums[mid] == target) {
            // mid可能是最后一个target值
            end = mid;
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