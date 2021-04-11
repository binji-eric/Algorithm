var restoreIpAddresses = function(s) {
    const res = [];
    if(s == null || s.length < 4 || s.length > 12) {
        return res;
    }
    const len = s.length;
    for(let a = 1; a < 4; a++) {
        for(let b = 1; b < 4; b++) {
            for(let c = 1; c < 4; c++) {
                const d = len - a - b- c;
                if(d < 1 || d > 3) {
                    continue;
                }
                
                const s1 = Number.parseInt(s.slice(0, a));
                const s2 = Number.parseInt(s.slice(a, a+b));
                const s3 = Number.parseInt(s.slice(a+b, a+b+c));
                const s4 = Number.parseInt(s.slice(a+b+c, len));
                // console.log(s1, s2, s3, s4);
                if(check(s1) && check(s2) && check(s3) && check(s4)) {
                    const temp = s1 + '.' + s2 + '.' + s3 + '.' + s4;
                    if(temp.length === len + 3) {
                        res.push(temp);
                    }
                }
            }
        }
    }
    return res;
};

var check = function(num) {
    if(num >= 0 && num <= 255) {
        return true;
    }
    return false;
}

console.log(restoreIpAddresses('25525511135'))