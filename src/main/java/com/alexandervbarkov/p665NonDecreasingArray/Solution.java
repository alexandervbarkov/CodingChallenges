package com.alexandervbarkov.p665NonDecreasingArray;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isNonDecreasing(4, 2, 3) + " == true");
        System.out.println(isNonDecreasing(3, 4, 2, 3) + " == false");
        System.out.println(isNonDecreasing(-1, 4, 2, 3) + " == true");
        System.out.println(isNonDecreasing(2, 3, 3, 2, 4) + " == true");
        System.out.println(isNonDecreasing(1, 2, 5, 4, 3) + " == false");
    }

    private static boolean isNonDecreasing(int... nums) {
        if (nums.length < 3) return true;
        boolean outOfOrder = false;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                if (outOfOrder) {
                    return false;
                } else {
                    outOfOrder = true;
                }
                if (i > 1) {
                    if(!(nums[i] < nums[i - 2])) {
                        nums[i - 1] = nums[i - 2];
                    } else {
                        nums[i] = nums[i - 1];
                    }
                    --i;
                }
            }
        }
        return true;
    }
}
