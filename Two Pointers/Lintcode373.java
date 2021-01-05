public void partitionArray(int[] nums) {
    // write your code here
    if(nums == null || nums.length == 0) {
        return;
    }
    int len = nums.length, index = 0, i = 0;
    for(; i < len; i++) {
        if(nums[i]%2 == 1) {
            swap(nums, i, index++);
        }
    }
}
private void swap(int[] nums, int index1, int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
}