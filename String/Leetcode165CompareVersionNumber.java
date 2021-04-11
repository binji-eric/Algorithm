class Solution {
    public int compareVersion(String version1, String version2) {
        // https://www.cnblogs.com/wzj4858/p/8204967.html
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len1 = arr1.length, len2 = arr2.length;
        for(int i = 0; i < Math.max(len1, len2); i++) {
            int first = i < len1? Integer.parseInt(arr1[i]): 0;
            int second = i < len2? Integer.parseInt(arr2[i]): 0;
            if(first < second) {
                return -1;
            } else if(first > second){
                return 1;
            }
        }
        return 0;
    }
}