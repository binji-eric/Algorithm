/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    const len = nums.length;
    let indexEmpty = 0;
    for(let j = 0; j < len; j++) {
        if(nums[j] != 0) {
            nums[indexEmpty++] = nums[j];
        }
    }
    for(let j = indexEmpty; j < len; j++)  {
        nums[j] = 0;
    }
    
};