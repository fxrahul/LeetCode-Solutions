// https://leetcode.com/problems/two-sum/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Arrays.sort(nums);
        int index = 0;
        int[] a = new int[2];
        /* O(n^2) complexity
        // for(int i = 0; i < nums.length; i++){
        //   for(int j = i+1; j< nums.length ; j ++){
        //       if(nums[i] + nums[j] == target){
        //           a[index++] = i;
        //           a[index] = j;
        //       }
        //   }
        // }
        */

        HashMap<Integer, Integer> s = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length ; i++){
            int rem = target - nums[i];
            if(s.containsKey(nums[i])){
                a[index++] = s.get(nums[i]);
                a[index] = i;
                break;
            }else{
                s.put(rem,i);
            }
        }

        return a;
    }
}