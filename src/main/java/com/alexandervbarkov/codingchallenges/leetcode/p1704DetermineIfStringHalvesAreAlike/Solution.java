package com.alexandervbarkov.codingchallenges.leetcode.p1704DetermineIfStringHalvesAreAlike;

class Solution {
    private static char [] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        String s = "book";
        System.out.println(s + " " + new Solution().halvesAreAlike(s));
        s = "textbook";
        System.out.println(s + " " + new Solution().halvesAreAlike(s));
    }

    public boolean halvesAreAlike(String s) {
        int length = s.length();
        if(length % 2 == 1) return false;
        s = s.toLowerCase();
        String a = s.substring(0, length / 2);
        String b = s.substring(length / 2);
        return countVowels(a) == countVowels(b);
    }

    private int countVowels(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            for (char vowel : vowels) {
                if(vowel == c) ++ count;
            }
        }
        return count;
    }
}