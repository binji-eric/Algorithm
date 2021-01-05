public void sortColors(int[] nums) {
    // write your code here
    if(nums == null || nums.length == 0) {
        return;
    }
    int pl = 0, i = 0, pr = nums.length - 1;
    // 如果是 i < pr，则有可能在i处的0无法移到前面
    while(i <= pr) {
        // 0 最左端
        if(nums[i] == 0) {
            swap(nums, i++, pl++);
            // 1 在中间
        } else if(nums[i] == 1) {
            i++;
            // 2在最右端
        } else {
            swap(nums, i, pr--);
        }
    }
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}