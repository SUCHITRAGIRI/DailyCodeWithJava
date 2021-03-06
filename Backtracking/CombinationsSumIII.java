//https://leetcode.com/problems/combination-sum-iii/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n < k)return res;
        find_combo(res, new ArrayList<>(), k, 1, n);
        return res;
    }
    public static void find_combo(List<List<Integer>> res, List<Integer> list, int k, int start, int n){

        if(k == list.size() && n == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= 9; i++){
            list.add(i);
            find_combo(res, list, k, i + 1, n - i);
            list.remove(list.size() - 1);
        }

    }
}
