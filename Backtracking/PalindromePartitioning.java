//https://leetcode.com/problems/palindrome-partitioning/submissions/
//It is my 1st approach using backtacking!
//But we can optimize it further by usinf DP.
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        
        helper(s, res, new ArrayList<>());
        return res;
    }
    
    public void helper(String s, List<List<String>> res, List<String> list){
        if(s.length() == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0; i < s.length(); i++){
            String curr = s.substring(0, i + 1);
            if(isPalindrome(curr)){
                list.add(curr);
                String rest = s.substring(i + 1);
                helper(rest, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j))return false;
            j--;
            i++;
        }
        return true;
    }
}

//No so much but bit optimized code.
class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<>();
        dfs(result, s, 0, new ArrayList<>(), dp);
        return result;
    }

    void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
        if (start >= s.length()) result.add(new ArrayList<>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                currentList.add(s.substring(start, end + 1));
                dfs(result, s, end + 1, currentList, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
