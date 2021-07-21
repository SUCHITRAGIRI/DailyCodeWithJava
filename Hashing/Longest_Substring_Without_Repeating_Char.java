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
   
 
//time 4ms
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

//More efficient 2ms
class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}

//Using queue but inefficient
//TC: O(N^2)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }
}    
    

    

