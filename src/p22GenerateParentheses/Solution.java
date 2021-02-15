package p22GenerateParentheses;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        return new LinkedList<>(generateParenthesisSet(n));
    }

    private Set<String> generateParenthesisSet(int n) {
        Set<String> parenthesisForN = new HashSet<>();
        if (n == 1) {
            parenthesisForN.add("()");
        } else {
            Set<String> parenthesisForNMinus1 = generateParenthesisSet(n - 1);
            for (String parenthesisString : parenthesisForNMinus1) {
                for (int i = 0; i < parenthesisString.length(); i++) {
                    if (parenthesisString.charAt(i) == '(') {
                        parenthesisForN.add(parenthesisString.substring(0, i + 1) + "()" + parenthesisString.substring(i + 1));
                    }
                }
                parenthesisForN.add("()" + parenthesisString);
            }
        }
        return parenthesisForN;
    }
}