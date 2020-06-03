// https://leetcode.com/problems/container-with-most-water/
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        /* brute force approach
        int k = 0;
        
        int maxArea = 0;
        while(k < n - 1){
            int l = k + 1;
            while (l < n){
                int area = Math.min(height[l], height[k]) * (l - k);
                maxArea = Math.max(area,maxArea);
                l++;
            }
            k++;
        }
        return maxArea;
        */

        ///* Efficient Solution
        int maxArea = 0;
        int i = 0;
        int j = n - 1;
        while(i < j){
            int area = Math.min(height[j], height[i]) * (j - i);
            maxArea = Math.max(area,maxArea);
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
        ///*

    }
}