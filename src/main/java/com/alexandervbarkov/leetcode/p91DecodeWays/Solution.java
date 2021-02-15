package com.alexandervbarkov.leetcode.p91DecodeWays;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("226"));
        System.out.println(new Solution().numDecodings("12"));
        System.out.println(new Solution().numDecodings("012"));
        System.out.println(new Solution().numDecodings("1"));
        System.out.println(new Solution().numDecodings("10"));
        System.out.println(new Solution().numDecodings("01"));
        System.out.println(new Solution().numDecodings("00"));
        System.out.println(new Solution().numDecodings("0"));
    }

    public int numDecodings(String s) {
        int startingIndex = 0;
        while (startingIndex < s.length() && s.charAt(startingIndex) == '0'){
            ++startingIndex;
        }
        if(startingIndex == s.length() + 1) return 0;
        if( startingIndex != 0) {
            s = s.substring(startingIndex);
        }

        if(s.length() == 1) return 1;

        int count = 0;
        int lastAddition = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int c1 = s.charAt(i) - 48;
            int c2 = s.charAt(i + 1) - 48;
            if (c1 < 3 && c2 < 7 && c2 != 0) {
                lastAddition = lastAddition == 2 ? 1 : 2;
                count += lastAddition;
            } else if (c1 < 3) {
                lastAddition = 1;
                ++count;
            }
        }
        return count > 0 ? count : 1;
    }
}