import java.util.ArrayList;
import java.util.HashSet;

//Problem: 217 - Contains Duplicate
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
//Constraints:
//  1. 1 <= nums.length <= 105
//  2. -109 <= nums[i] <= 109

public class ContainsDuplicate{
    //There are two ways to approach this problem
    //  1. We can either check values one by one until we find duplicate 
    //      - But this will be O(n) speed
    //      - And O(1) memory
    //  2. We can first sort the array of numbers
    //      - This will first require sort but then all that we need is one traversal 
    //      - Takes extra memory for the sort
    public static void main(String[] args) {
        int[] test1 = {1,2,3,1};             //true
        int[] test2 = {1,2,3,4};             //false
        int[] test3 = {1,1,1,3,3,4,3,2,4,2}; //true 
        int[] test4 = {2,3,4,4};             //true

        ArrayList<int []> tests = new ArrayList<>();
        tests.add(test1);
        tests.add(test2);
        tests.add(test3);
        tests.add(test4);

        System.out.println("Tests for HashSet:");
        for(int[] test: tests){
            System.out.println(containsDuplicateMemory(test));
        }

        System.out.println("Tests for Nested Loop:");
        for(int[] test: tests){
            System.out.println(containsDuplicateCompute(test));
        }

        
    }
    
    public static boolean containsDuplicateCompute(int[] nums) {
        //Time complexity of O(n^numNestedLoops) so in this case we get O(n^2)
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicateMemory(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            //HashSet.add() has a time complexity of O(1) time
            if(!set.add(i)){
                return true;
            }
        }
        return false;
    }
}