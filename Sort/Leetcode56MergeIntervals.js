/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
 var merge = function(intervals) {
    if(intervals == null || intervals.length == 0) {
        return intervals;
    }
    intervals.sort((a, b) => {
        return a[0] -b[0];
    })
    const res = [];
    let previous = null;
    for(let interval of intervals) {
        if(previous == null || previous[1] < interval[0]) {
            res.push(interval);
            previous = interval;
        } else {
            previous[1] = Math.max(interval[1], previous[1]);
        }
    }
    return res;
};