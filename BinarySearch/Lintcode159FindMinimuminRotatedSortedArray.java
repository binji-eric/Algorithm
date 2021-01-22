public int findMin(int[] nums) {
    if(nums == null || nums.length < 1) {
        return 0;
    }
    int left = 0, right = nums.length - 1;
    while(left + 1 < right) {
        int mid = left + (right - left)/2;
        if(nums[mid] < nums[right]) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    if(nums[left] < nums[right]) {
        return nums[left];
    } else {
        return nums[right];
    }
}