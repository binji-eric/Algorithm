/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    let i = 0, j = s.length - 1;
    const str = s.toLowerCase();
    while(i < j) {
        if(!isValid(str[i])) {
            i++;
            continue;
        }
        if(!isValid(str[j])) {
            j--;
            continue;
        }
        if(str[i] != str[j]) {
            return false;
        } else {
            i++;
            j--;
        }
    }
    return true;
};

function isValid(ch) {
    if(ch >= 'a' && ch <= 'z' || ch >= '0' &&  ch <= '9') {
        return true;
    }
    return false;
}