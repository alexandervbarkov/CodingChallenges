package com.alexandervbarkov.codingchallenges.leetcode.p136SingleNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        return set.iterator().next();
    }
}
