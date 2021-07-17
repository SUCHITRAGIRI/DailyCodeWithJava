//
//Using set(for avoid duplication) but here Time taken (460ms) is high!
public  List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
           int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if ( sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);
    }

//Time taken : 16ms
//continue statement are used for avoid duplication!
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
       
        if(nums.length < 3)return res;
       
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] + nums[i + 1] + nums[i + 2] > 0)break; // 1st no is too big
            if(nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0)continue; //1st no is too small
            if(i > 0 && nums[i - 1] == nums[i])continue;
            int low = i + 1;
            int high = nums.length - 1;
            
                while(low<high){
                 int old_l = low;
                 int old_h = high;
                if(nums[i] + nums[low] + nums[high] == 0){   
                res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                while(low<high&&nums[low]==nums[old_l])low++; //skipping over duplicate on low
                while(low<high&&nums[high]==nums[old_h])high--; //skipping over duplicate on high
                } 
                else if(nums[i] + nums[low] + nums[high] < 0)low++; 
                else high--;
            }
        }
        return res;
    }
}
