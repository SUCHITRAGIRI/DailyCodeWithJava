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


