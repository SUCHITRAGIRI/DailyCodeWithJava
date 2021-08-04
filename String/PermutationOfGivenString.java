//https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1#


class Solution {
    public List<String> find_permutation(String S) {
        List<String> res = new ArrayList<>();
        
        char[] char1 = new char[S.length()];
        char1 = S.toCharArray();
        Arrays.sort(char1);
        String s = "";
        for(char ch : char1){
             s += ch;
        }
        helper(res, s, "");
        
        return res;
    }
    
    public void helper(List<String> res, String s, String ans){
        if(s.length() == 0){
            res.add(ans);
            return;
        }
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1, s.length());
            String ros = left + right;
            helper(res, ros, ans + ch);
        }
    }
}
