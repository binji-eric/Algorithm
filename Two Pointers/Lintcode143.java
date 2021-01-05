public void sortColors2(int[] colors, int k) {
    // write your code here
    if(colors == null || colors.length == 0) {
        return;
    }
    int len = colors.length;
    rainbowSort(colors, 0, len - 1, 1, k);
}

private void rainbowSort(int[] nums, int left, int right, int colorBegin, int colorEnd) {
    if(left >= right || colorBegin >= colorEnd) {
        return;
    }
    int i = left, j = right, mid = (colorBegin + colorEnd)/2;
    while(i <= j) {
        while(i <= j && nums[i] <= mid) {
            i++;
        }
        while(i <= j && nums[j] > mid) {
            j--;
        }
        if(i <= j) {
            swap(nums, i++, j--);
        }
    }
    rainbowSort(nums, left, j, colorBegin, mid);
    rainbowSort(nums, j+1, right, mid + 1, colorEnd);
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}