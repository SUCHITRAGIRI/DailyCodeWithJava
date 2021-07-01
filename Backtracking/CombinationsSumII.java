//https://leetcode.com/problems/combination-sum-ii/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        find_combo(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }
    public static void find_combo(int[] arr, List<List<Integer>> res, List<Integer> list, int target, int start){
        if(target < 0)return;
        if(target == 0){
            res.add(new ArrayList(list));
            return;

        }
        for(int i = start; i < arr.length; i++){
            if(i > start && arr[i] == arr[i - 1])continue;
            list.add(arr[i]);
            find_combo(arr, res, list, target - arr[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
 }
