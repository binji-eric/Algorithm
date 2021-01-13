class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return nums[0];
        }
        int[] L = new int[3];
        int[] R = new int[3];
        L[1] = nums[0];
        R[1] = nums[1];
        for (int i = 2;i < size;i++) {
            //递推公式，注意nums中数的顺序先后
            L[i%3] = Math.max(L[(i - 2)%3] + nums[i - 1],L[(i - 1)%3]);
            R[i%3] = Math.max(R[(i - 2)%3] + nums[i],  R[(i - 1)%3]);
        }
        return Math.max(L[(size - 1)%3],R[(size - 1)%3]);//取较大值
    }
}