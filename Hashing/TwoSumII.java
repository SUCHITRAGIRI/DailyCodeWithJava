//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = numbers.length - 1;
       while(i < j){
           if(numbers[i] + numbers[j] == target){
               arr[0] = i + 1;
               arr[1] = j + 1;
               break;
           }else if(numbers[i] + numbers[j] > target){
               j--;
           }else if(numbers[i] + numbers[j] < target){
               i++;
           }
       }
        return arr;
    }
}
