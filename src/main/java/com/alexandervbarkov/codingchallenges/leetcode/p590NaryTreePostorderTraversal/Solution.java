package com.alexandervbarkov.codingchallenges.leetcode.p590NaryTreePostorderTraversal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().postorder(
                new Node(1, asList(
                        new Node(3, asList(
                                new Node(5),
                                new Node(6))),
                        new Node(2),
                        new Node(4)
                ))));
    }

    public List<Integer> postorder(Node root) {
        if (root == null) return Collections.emptyList();
        List<Integer> integers = root.children == null || root.children.isEmpty()
                ? new LinkedList<>()
                : root.children
                    .stream()
                    .map(this::postorder)
                    .flatMap(ints -> ints.stream())
                    .collect(Collectors.toList());
        integers.add(root.val);
        return integers;
    }
}