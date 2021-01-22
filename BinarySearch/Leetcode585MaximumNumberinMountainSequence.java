// Given a mountain sequence of n integers which increase firstly and then decrease, 
// find the mountain top.

public int mountainSequence(int[] nums) {
    // write your code here
    if(nums == null || nums.length == 0) {
        return -1;
    }
    int len = nums.length;
    if(len == 1) {
        return nums[0];
    }
    int left = 0, right = nums.length - 1;
    while(left + 1 < right) {
        int mid = left + (right - left)/2;
        // 判断走势
        if(nums[mid+1] > nums[mid]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    if(nums[left] > nums[right]) {
        return nums[left];
    } else {
        return nums[right];
    }
}