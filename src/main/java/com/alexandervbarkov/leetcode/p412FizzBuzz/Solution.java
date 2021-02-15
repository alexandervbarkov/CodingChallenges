package com.alexandervbarkov.leetcode.p412FizzBuzz;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        int i = 0;
        while (++i <= n) {
            String s = "";
            if (i % 3 == 0) s = s.concat("Fizz");
            if (i % 5 == 0) s = s.concat("Buzz");
            if (s.isEmpty()) s = s.concat(String.valueOf(i));
            list.add(s);
        }
        return list;
    }
}
