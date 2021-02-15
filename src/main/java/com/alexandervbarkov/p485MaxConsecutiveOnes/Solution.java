package com.alexandervbarkov.p485MaxConsecutiveOnes;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        for (int num : nums) {
            if (num == 1) ++currentCount;
            else {
                if (currentCount > maxCount) maxCount = currentCount;
                currentCount = 0;
            }
        }
        return currentCount > maxCount ? currentCount : maxCount;
    }
}
