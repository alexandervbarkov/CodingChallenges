package com.alexandervbarkov.codingchallenges.leetcode.p7ReverseInteger;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse2(123));
    }
    public int reverse(int x) {
        String s = String.valueOf(x);
        if (x < 0)
            s = s.substring(1);
        char[] chars = s.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0, j = chars.length - 1; i < chars.length; ++i, --j) {
            reversed[j] = chars[i];
        }
        int i;
        try {
            i = Integer.valueOf(new String(reversed));
        } catch (Exception e) {
            return 0;
        }
        if (x < 0)
            i *= -1;
        return i;
    }

    public int reverse2(int x) {
        int i = 0;

        boolean isNegative = x < 0;

        if (isNegative)
            x *= -1;

        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < i)
                return 0;
            i *= 10;
            i += x % 10;
            x /= 10;
        }

        if (isNegative)
            i *= -1;

        return i;
    }
}
