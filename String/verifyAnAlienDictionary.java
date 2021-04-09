

// 953: Leetcode Problem(April DailyChallange) 
// https://leetcode.com/problems/verifying-an-alien-dictionary/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        //store the order of each letter in n array
        for(int i = 0; i < orderMap.length; i++){
            orderMap[order.charAt(i) - 'a'] = i;
        }
        //
        for(int i = 0; i < words.length - 1; i++){
            for(int j = 0; j < words[i].length(); j++){
                 // If we do not find a mismatch letter between words[i] and words[i + 1],
                // we need to examine the case when words are like ("apple", "app").
                //left word is greater than right
                if(j >= words[i + 1].length())return false;
                if(words[i].charAt(j) != words[i + 1].charAt(j)){
                    int leftOrder = orderMap[words[i].charAt(j) - 'a'];
                    int rightOrder = orderMap[words[i + 1].charAt(j) - 'a'];
                    if(leftOrder > rightOrder)return false;
                     // if we find the first different letter and they are sorted,
                    // then there's no need to check remaining letters
                    else break;
                }
                
            }
        }
        return true;
    }
}
