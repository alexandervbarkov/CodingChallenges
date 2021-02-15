package com.alexandervbarkov.p4MedianOfTwoSortedArrays;

public class Solution {
    public static void main(String[] args) {
//        int[] nums1 = {1};
//        int[] nums2 = {2, 3, 4, 5, 6};
//        int[] nums1 = {2, 4};
//        int[] nums2 = {1, 3, 5, 6};
        int[] nums1 = {2, 3};
        int[] nums2 = {1, 4, 5, 6};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int min1 = nums1[0];
        int max1 = nums1[nums1.length - 1];
        int min2 = nums2[0];
        int max2 = nums2[nums2.length - 1];
        if (min2 > max1) {
            return findMedianWhenMaxOfArray1IsLessThanMinOfArray2(nums1, nums2);
        } else if (min1 > max2) {
            return findMedianWhenMaxOfArray1IsLessThanMinOfArray2(nums2, nums1);
        } else if (min1 < min2 && max1 < max2) {

        } else if (min2 < min1 && max2 < max1) {

        } else if (min1 < min2 && max1 > max2) {

        } else if (min2 < min1 && max2 > max1) {
            return findMedianWhenArray1IsInsideOfArray2(nums1, nums2);
        }
        return 0;
    }

    private double findMedianWhenArray1IsInsideOfArray2(int[] nums1, int[] nums2) {
        int rightInnerBoundOfArray1 = 0; //index of the last biggest number of array1 before min2
        int leftInnerBoundOfArray1 = 0; //index of the first biggest number of array1 after max2
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 1) {
            int centerIndex = totalLength / 2;
            return getValueForIndexFromTwoEntirelyOverlappingArrays(nums1, nums2, centerIndex);
        } else {
            int rightIndex = totalLength / 2;
            int leftIndex = rightIndex - 1;
            int rightValue = getValueForIndexFromTwoEntirelyOverlappingArrays(nums1, nums2, rightIndex);
            int leftValue = getValueForIndexFromTwoEntirelyOverlappingArrays(nums1, nums2, leftIndex);
            return (double)(rightValue + leftValue) / 2;
        }
    }

    private double findMedianWhenMaxOfArray1IsLessThanMinOfArray2(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 1) {
            int centerIndex = totalLength / 2;
            return getValueForIndexFromTwoNonOverlappingArrays(nums1, nums2, centerIndex);
        } else {
            int rightIndex = totalLength / 2;
            int leftIndex = rightIndex - 1;
            int rightValue = getValueForIndexFromTwoNonOverlappingArrays(nums1, nums2, rightIndex);
            int leftValue = getValueForIndexFromTwoNonOverlappingArrays(nums1, nums2, leftIndex);
            return (double)(rightValue + leftValue) / 2;
        }
    }

    private int getValueForIndexFromTwoNonOverlappingArrays(int[] nums1, int[] nums2, int index) {
        return index < nums1.length ? nums1[index] : nums2[index - nums1.length];
    }

    private int getValueForIndexFromTwoEntirelyOverlappingArrays(int[] nums1, int[] nums2, int index) {
        return index < nums1.length ? nums1[index] : nums2[index - nums1.length];
    }
}
