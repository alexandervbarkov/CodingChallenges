package com.alexandervbarkov.leetcode.p9PalindromeNumber

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {
    @Unroll
    def "IsPalindrome #x"() {
        expect:
        new Solution().isPalindrome(x) == expected

        where:
        x   | expected
        1   | true
        12  | false
        123 | false
        131 | true
    }
}
