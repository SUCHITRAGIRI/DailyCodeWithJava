//https://leetcode.com/problems/combination-sum/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       // Arrays.sort(candidates);
        List<List<Integer>> res  = new ArrayList();
        find_comboSum(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }
    public static void find_comboSum(int[] arr, List<List<Integer>> res, List<Integer> list, int target, int start){
        if(target < 0)return;
        if(target == 0){
            res.add(new ArrayList(list));
            return;
        }

        for(int i = start; i < arr.length; i++){
            list.add(arr[i]);
        find_comboSum(arr, res, list, target - arr[i], i);
            list.remove(list.size() - 1);

        }
    }
 }
