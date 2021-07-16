//https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1/?track=dsa-workshop-1-hashing&batchId=308#
//https://leetcode.com/problems/4sum/submissions/
//O(n^3)
//O(n^2)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1])continue;
        for(int j = i + 1; j < n - 2; j++){
             if(j > i + 1 && nums[j] == nums[j - 1])continue;
              int sum = nums[i] + nums[j];
              int req = target - sum;
                int left = j + 1;
                int right = n - 1;
                
                while(left < right){
                    int l_old = left;
                    int r_old = right;
                    if(nums[left] + nums[right] == req){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                         while(left < right && nums[left] == nums[l_old])left++;
                         while(left < right && nums[left] == nums[r_old])right--;
      
                    }else if(nums[left] + nums[right] < req){
                        left++;
                    }else{
                        right--;
                    }
                }
                
            }
        }
        return res;
    }
}

//optimize code

public class Solution {
public List<List<Integer>> fourSum(int[] num, int target) {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    if(num.length<4)return ans;
    Arrays.sort(num);
    for(int i=0; i<num.length-3; i++){
      
        if(num[i]+num[i+1]+num[i+2]+num[i+3]>target)break; //first candidate too large, search finished
      
        if(num[i]+num[num.length-1]+num[num.length-2]+num[num.length-3]<target)continue; //first candidate too small
      
        if(i>0&&num[i]==num[i-1])continue; //prevents duplicate result in ans list
      
        for(int j=i+1; j<num.length-2; j++){
          
            if(num[i]+num[j]+num[j+1]+num[j+2]>target)break; //second candidate too large
          
            if(num[i]+num[j]+num[num.length-1]+num[num.length-2]<target)continue; //second candidate too small
          
            if(j>i+1&&num[j]==num[j-1])continue; //prevents duplicate results in ans list
          
            int low=j+1, high=num.length-1;
          
            while(low<high){
                int sum=num[i]+num[j]+num[low]+num[high];
                if(sum==target){
                    ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                    while(low<high&&num[low]==num[low+1])low++; //skipping over duplicate on low
                    while(low<high&&num[high]==num[high-1])high--; //skipping over duplicate on high
                    low++; 
                    high--;
                }
                //move window
                else if(sum<target)low++; 
                else high--;
            }
        }
    }
    return ans;
}
}
