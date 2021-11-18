//https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/


class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for(String p : patterns){
            if(word.contains(p))res++;
        }
        
        return res;
    }
}
