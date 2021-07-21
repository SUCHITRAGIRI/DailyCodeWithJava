//https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Logic : Using extra space which is HashMap.
//         use two pointers left and right, both initiated with 0 index.
//         len = 0 ( maximum length of string)
//         make a while loop upto the string length
//         and check if character contains in a map or not
//         if not contains
//         then simply put the char as key and index as value
//         and update the len should be from left to right so, we can simply write (right - left + 1)
//         if contains then upadate the left pointer (means left pointer is just used for maintainig the max lenth as well as avoid duplicacy)
   
          
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, len = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}
