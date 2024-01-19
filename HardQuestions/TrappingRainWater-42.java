// 42 - Trapping Rain Water 
// Given n non-negative integers representing an elevation map where the width of each bar is 1, 
//compute how much water it can trap after raining.
class Solution {
    

    // Function to return the maximum 
    // water that can be stored 
    public static int trap(int[] height) 
    { 
  
        int n = height.length;
        // To store the maximum water 
        // that can be stored 
        int res = 0; 
  
        // For every element of the heightay 
        // except first and last element 
        for (int i = 1; i < n - 1; i++) { 
  
            // Find maximum element on its left 
            int left = height[i]; 
            for (int j = 0; j < i; j++) { 
                left = Math.max(left, height[j]); 
            } 
  
            // Find maximum element on its right 
            int right = height[i]; 
            for (int j = i + 1; j < n; j++) { 
                right = Math.max(right, height[j]); 
            } 
  
            // Update maximum water value 
            res += Math.min(left, right) - height[i]; 
        } 
        return res; 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; 
        
  
        System.out.print(trap(height)); 
    } 
} 

    
