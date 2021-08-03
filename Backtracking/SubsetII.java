//https://leetcode.com/problems/subsets-ii/

//Very nice problem :
//This problem can be solve : 1) using backtracking 2) Bit manipulation 3) Iterative
//Here is my solution 

//1st approach came in my mind is this👇
class Solution {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);       
        helper(nums, 0, new ArrayList<Integer>());  
        List<List<Integer>> list = new ArrayList<>();
        list.addAll(res);
        return list;
    }
    
    public void helper(int[] nums, int i, List<Integer> list){
        //edge case when it travese whole array nd reached the n index 
        if(nums.length == i){
            res.add(new ArrayList(list));
            return;
        }
        helper(nums, i + 1, list); //don't pick
        list.add(nums[i]);
        helper(nums, i + 1, list);//pick
        list.remove(list.size() - 1);    //backtack
    }
}
//Although it is not optimize 


//So, here is the optimize solution:
package backtrack;
import java.util.*;

public class SubsetII {

	public static void main(String[] args) {
	int[] nums = {2, 1, 2};
	System.out.println(subsetsWithDup(nums));
	}
	    public static List<List<Integer>> subsetsWithDup(int[] nums) {
	    List<List<Integer>> res = new ArrayList<>();
	    Arrays.sort(nums);    
	    backtrack(res, new ArrayList<>(), nums, 0);    
	        return res;
	    }
	    public static void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int start){
	       
	        res.add(new ArrayList<>(list));
	        for(int i = start; i < nums.length; i++){
	            if(i > start && nums[i] == nums[i-1]) continue;
	            list.add(nums[i]);
	            backtrack(res, list, nums, i + 1);
	            list.remove(list.size() - 1);
	        }
	    }
	}

//Iterative approach
public List<List<Integer>> subsetsWithDup(int[] num) {
  Arrays.sort(num);
  List<List<Integer>> ret = new ArrayList<>();
  ret.add(new ArrayList<Integer>());

  int size = 0, startIndex;
  for(int i = 0; i < num.length; i++) {
    startIndex = (i >= 1 && num[i] == num[i - 1]) ? size : 0;
    size = ret.size();
    for(int j = startIndex; j < size; j++) {
      List<Integer> temp = new ArrayList<>(ret.get(j));
      temp.add(num[i]);
      ret.add(temp);
    }
  }
  return ret;
}

//Bit manipulation

  public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> lists = new ArrayList<>();
        int subsetNum = 1<<num.length;
        for(int i=0;i<subsetNum;i++){
            List<Integer> list = new ArrayList<>();
            boolean illegal=false;
            for(int j=0;j<num.length;j++){
                if((i>>j&1)==1){
                    if(j>0&&num[j]==num[j-1]&&(i>>(j-1)&1)==0){
                        illegal=true;
                        break;
                    }else{
                        list.add(num[j]);
                    }
                }
            }
            if(!illegal){
               lists.add(list); 
            }
            
        }
        return lists;
    }
}




