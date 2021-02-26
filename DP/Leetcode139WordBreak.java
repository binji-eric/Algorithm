// Given a non-empty string s and a dictionary wordDict 
// containing a list of non-empty words, 
// determine if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note:

// The same word in the dictionary may be reused multiple times in the segmentation.
// You may assume the dictionary does not contain duplicate words.

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) {
            return false;
        } 
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        HashSet<String> set = new HashSet<String>();
        for(String word: wordDict) {
            set.add(word);
        }
        for(int i = 0; i <= len; i++) {
            for(int j = 0; j < i; j++) {
                String temp = s.substring(j, i);
                if(set.contains(temp) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}