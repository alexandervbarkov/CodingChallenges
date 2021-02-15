package com.alexandervbarkov.leetcode.p152MaximumProductSubarray;

class Solution {
    public static void main(String[] args) {
        int [] nums = {2,3,-2,4};
        System.out.println(new Solution().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        for (int l = 0; l < nums.length; ++l) {
            int currentMax = nums[l];
            if(currentMax > globalMax) {
                globalMax = currentMax;
            }
            if(currentMax == 0) {
                continue;
            }
            for(int r = l + 1; r < nums.length; ++r) {
                currentMax *= nums[r];
                if(currentMax > globalMax) {
                    globalMax = currentMax;
                }
                if(currentMax == 0) {
                    break;
                }
            }
        }
        return globalMax;
    }
}