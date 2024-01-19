import java.util.HashMap;

/**
 * 1 - Two Sum
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * Constraints:
 *  2 <= nums.length <= 104
 *  -109 <= nums[i] <= 109
 *  -109 <= target <= 109
 *  Only one valid answer exists.
 * 
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 */
public class TwoSum {

    public static void main(String[] args) {
        
    }

    //Possible solutions include: 
    //Check each int against each other to find which two sum up to target
    //
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 2){
            return(new int[] {0,1});
        }
        else{
            HashMap<Integer, Integer> set = new HashMap<>();
            
            for(int i = 0; i < nums.length; i++){
                if(set.containsKey(target - nums[i])){
                    return(new int[] {i, set.get(target - nums[i])});
                }
                if(!set.containsKey(nums[i])){
                    set.put(nums[i],i);
                }
            }
        }
        return null;
    }


}