var reverseWords = function(s) {
    const arr = s.trim().split(' ');
    let start = 0, end = arr.length-1;
    while(start < end) {
        swap(arr, start++, end--);
    }
    let res = arr[0];
    for(let i = 1; i < arr.length; i++) {
        // 如果单词之间的间隔多于1个，那么split的结果中可能会有空串
        if(arr[i] != '')
            res = res + ' ' + arr[i];
    }
    return res;
};

function swap(arr, i, j) {
    const temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}