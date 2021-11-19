//

//Using Brute force: O(M*N)
class Solution {
    public int strStr(String haystack, String needle) {
        //using brute force
        int n = haystack.length();
        int m = needle.length();
        
        for(int i = 0; i < n - m + 1; i++){
            int j;
            for(j = 0; j < m; j++){
                if(haystack.charAt(i + j) != needle.charAt(j))break;
            }
            if(j == m)return i;//found
        }
        return -1;
    }
}


//
class Solution {
    public int strStr(String haystack, String needle) {
        int i, n = haystack.length();
        int j, m = needle.length();
        
        for(i = 0, j = 0; i < n && j < m; i++){
            if(haystack.charAt(i) == needle.charAt(j))j++;
            else{
                i -= j;
                j = 0;
            }
        }
        if(j == m)return i - m;
        return -1;
    }
}



//Using KMP algorithm: O(M + N)
public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        
        int[] parr = kmpPreprocess(needle);
        int i = 0, j = 0;
        while(i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
            } else if(j > 0) {
                j = parr[j - 1];
            } else {
                i++;
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private int[] kmpPreprocess(String pattern) {
        int i = 1, j = 0;
        int[] res = new int[pattern.length()];
        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                res[i] = j+1;
                i++; j++;
            } else if (j > 0) {
                j = res[j-1];
            } else {
                res[i] = 0;
                i++;
            }
        }
        return res;
    }

