package Sort;

public class Leetcode75SortColors {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }
        int left = 0, right = nums.length - 1;
        for(int num: nums) {
            if(num == 0) {
                left++;
            } else if(num == 2){
                right--;
            } else {
                continue;
            }
        }
        for(int i = 0; i < left; i++) {
            nums[i] = 0;
        }
        for(int i = nums.length -1; i > right; i--) {
            nums[i] = 2;
        }
        for(int i = left; i<= right; i++) {
            nums[i] = 1;
        }
    }
}
