/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if(nums.length <= 2) {
           return nums.length;
       }
       let index=2; // 允许重复两次，可以修改为三次
       for(let i=2; i < nums.length; i++)
       {
           if(nums[i]!=nums[index-2]) // 允许重复两次，可以修改为三次
           {
               nums[index++]=nums[i];
           }
       }
       return index;

};