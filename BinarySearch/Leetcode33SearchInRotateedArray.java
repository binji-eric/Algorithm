public int search(int[] nums, int target) {
      
    int len=nums.length;
     int low=0,end=len-1;
 
     while(low<=end)
     {
         int mid=low+(end-low)/2;
         if(nums[mid]==target)
             return mid;
         if(nums[mid]>=nums[low])  //左侧有序
         {
             if(target<nums[mid]&&target>=nums[low])
                 end=mid-1;
             else
                 low=mid+1;
         }
         else// the right side is ordered
         {
             if(target>nums[mid]&&target<=nums[end])
                 low=mid+1;
             else
                 end=mid-1;
         }
     }
     return -1;
     
 }