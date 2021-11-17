//https://leetcode.com/problems/count-items-matching-a-rule/


//Time : O(N), where N is the size of items list
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0, count = 0;
        if(ruleKey.equals("type")){
            ans = 0;
        }else if(ruleKey.equals("color")){
            ans = 1;
        }else if(ruleKey.equals("name")){
            ans = 2;
        }
        for(int i = 0; i < items.size(); i++){   
            
            if(ruleValue.equals(items.get(i).get(ans)))
            count++;
        }
        return count;
    }
}


class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        
        for(int i = 0 ;i<items.size();i++){
            if(ruleKey.equals("type") && items.get(i).get(0).equals(ruleValue)) res++;
            if(ruleKey.equals("color") && items.get(i).get(1).equals(ruleValue)) res++;
            if(ruleKey.equals("name") && items.get(i).get(2).equals(ruleValue)) res++;
        }
        
        return res;
        
    }
}
