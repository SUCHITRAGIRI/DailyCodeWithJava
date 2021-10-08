//https://leetcode.com/problems/find-all-anagrams-in-a-string/

//two pointer approch
//In 1st attempt I came up with this solution!
//Tc:
//Space : 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length())return res;
        int k = p.length();
        int j = 0;
        for(int i = k - 1; i < s.length(); i++){            
            //while(i - j + 1 < k)i++;           
            if(isAnagram(s, p, j, i)){
                res.add(j);
            }           
            j++;
        } 
        return res;
    }   
    
    public boolean isAnagram(String s, String p, int start, int end){
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        String s1 = s.substring(start, end + 1);
        for(int i = 0; i < p.length(); i++){
            arr1[s1.charAt(i) - 'a']++;
            arr2[p.charAt(i) - 'a']++;
        }
        
        return Arrays.equals(arr1, arr2);
    }
}


//Optimized code
//Tc : O(N)
// SC: O(1)
class Solution {
   public List<Integer> findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
    int[] hash = new int[256]; //character hash
    //record each character in p to hash
    for (char c : p.toCharArray()) {
        hash[c]++;
    }
    //two points, initialize count to p's length
    int left = 0, right = 0, count = p.length();
    while (right < s.length()) {
        //move right everytime, if the character exists in p's hash, decrease the count
        //current hash value >= 1 means the character is existing in p
        if (hash[s.charAt(right++)]-- >= 1) count--; 
        
        //when the count is down to 0, means we found the right anagram
        //then add window's left to result list
        if (count == 0) list.add(left);
    
        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
        //++ to reset the hash because we kicked out the left
        //only increase the count if the character is in p
        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
    }
    return list;
}
}
