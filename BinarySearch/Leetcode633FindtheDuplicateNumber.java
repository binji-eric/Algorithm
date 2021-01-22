// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
// guarantee that at least one duplicate number must exist. 
// Assume that there is only one duplicate number, find the duplicate one.

public int findDuplicate(int[] nums) {
    // write your code here
    if(nums == null || nums.length < 2) {
        return -1;
    }
    int len = nums.length;
    int left = 0, right = len-1;
    while(left + 1 < right) {
        int mid = left + (right-left)/2;
        boolean res = check(nums, mid);
        if(res) {
            // 结果可能包含在mid中
            right = mid;
        } else {
            // 结果一定不在mid中
            left = mid + 1;
        }
    }
    if(check(nums, left)) {
        return left;
    }
    return right;
}

private boolean check(int[] nums, int num) {
    int cnt = 0;
    // 如果cnt > num,说明在<num的数中，一定有重复的数字
    for(int ele: nums) {
        if(ele <= num) {
            cnt++;
        }
    }
    return cnt > num;
}