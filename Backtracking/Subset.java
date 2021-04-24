package backtrack;
import java.util.*;

public class Subset {

	public static void main(String[] args) {
	 int[] nums = {1, 2, 3};
     ///subsets(nums);
     System.out.println(subsets(nums));
	}
	    public static List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        find_subset(res, new ArrayList<>(), nums, 0);
	        return res;
	    }
	    public static void find_subset(List<List<Integer>> res, List<Integer> list, int[] nums, int start){
	       res.add(new ArrayList<>(list)); 
	       for(int i = start; i < nums.length; i ++){
	           list.add(nums[i]);
	           find_subset(res, list, nums, i + 1);
	           list.remove(list.size() - 1);
	       } 
	    }
	}


