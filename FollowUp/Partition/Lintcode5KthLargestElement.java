package FollowUp.Partition;

// PriorityQueue 时间复杂度O(nlogk) 更适合Topk
//  QuickSelect 时间复杂度O(n) 更适合第k大

public int kthLargestElement(int k, int[] nums) {
    int n = nums.length;
    // 为了方便编写代码，这里将第 k 大转换成第 k 小问题。
    k = n - k;
    return partition(nums, 0, n - 1, k);
}
public int partition(int[] nums, int start, int end, int k) {
    Random random = new Random();
    int pivot = random.nextInt(end - start +1) + start;
    swap(nums, pivot, end);
    int index = start;
    for(int i = start; i <= end; i++) {
        if(nums[i] < nums[end]){
          swap(nums, index, i);
          index++;
        }
      }
      swap(nums, index, end);
    
    // 如果第 k 小在右侧，搜索右边的范围，否则搜索左侧。
    if (k < index) {
        return partition(nums, start, index-1, k);
    }
    if (k > index) {
        return partition(nums, index+1, end, k);
    }
    return nums[k];
}
public void swap(int[] nums, int x, int y) {
    int temp = nums[x];
    nums[x] = nums[y];
    nums[y] = temp;
}
}