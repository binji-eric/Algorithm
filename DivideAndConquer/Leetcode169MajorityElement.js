
function majorityWithIndex(nums, start, end) {
    if(start == end) {
        return nums[start];
    }
    const mid = start + Math.floor((end-start)/2);
    const left = majorityWithIndex(nums, start, mid);
    const right = majorityWithIndex(nums, mid+1, end);
    if(left == right) {
        return left;
    }
    const leftCount = counter(nums, start, mid, left);
    const rightCount = counter(nums, mid+1, end, right);
    return leftCount > rightCount? left: right;
}

function counter(nums, start, end, target) {
    let count = 0;
    for(let i = start;  i <= end; i++) {
        if(nums[i] === target) {
            count++;
        }
    }
    return count;
}