//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        
        List<Boolean> res = new ArrayList<>();
        for(int i = 1; i < candies.length; i++){
            max = Math.max(max, candies[i]);
        }
        
        for(int i = 0; i < candies.length; i++){
            if(extraCandies + candies[i] < max)res.add(false);
            
            else res.add(true);
                                
        }
        
        return res;
    }
}

// Further optimization
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>(candies.length);
        int max = 0;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }
        for (int candy : candies) {
            ans.add(candy + extraCandies >= max);
        }
        return ans;
    }
}


//Minnor optimization
//Deduct extraCandies from max to avoid plus n times.
class Solution {
public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>(candies.length);
        int gauge = 0;
        for (int candy : candies) {
            gauge = Math.max(candy, gauge);
        }
		gauge -= extraCandies;
        for (int candy : candies) {
            ans.add(candy >= gauge);
        }
        return ans;
    }
    }

//Another way using stream Api
class Solution {
public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= max).collect(Collectors.toList());
    }
    }


