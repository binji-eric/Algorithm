public void wiggleSort(int[] nums) {
    // write your code here
   int len = nums.length;
   int temp = 0;
   for(int i = 1; i<len; i++){
       if(i%2 == 0 && nums[i] > nums[i-1])
       {
          swap(nums, i, i-1);
       }
       else if(i%2 == 1 && nums[i] < nums[i-1])
       {
           swap(nums, i, i-1);
       }
   }
   return;
}

private void swap(int[] nums, int index1,int index2) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
}