public int binarySearch(int[] nums, int target) {
    // write your code here
    int start = 0, end = nums.length - 1;
    while(start + 1 < end) {
        int mid = start + (end - start)/2;
        if(nums[mid] == target) {
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