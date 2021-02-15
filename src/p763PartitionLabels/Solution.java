package p763PartitionLabels;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(new Solution().partitionLabels("aebbedaddc"));
    }

    public List<Integer> partitionLabels(String S) {
        List<Set<Character>> charsSets = new LinkedList<>();
        for (int stringIndex = 0; stringIndex < S.length(); stringIndex++) {
            char c = S.charAt(stringIndex);
            boolean present = false;
            for (int charsSetsIndex = 0; charsSetsIndex < charsSets.size(); charsSetsIndex++) {
                Set<Character> set = charsSets.get(charsSetsIndex);
                if (set.contains(c)) {
                    present = true;
                    while (charsSetsIndex + 1 < charsSets.size()) {
                        set.addAll(charsSets.get(charsSetsIndex + 1));
                        charsSets.remove(charsSetsIndex + 1);
                    }
                }
            }
            if (!present) {
                HashSet<Character> newChars = new HashSet<>();
                newChars.add(c);
                charsSets.add(newChars);
            }
        }

        List<Integer> lastIndexes = charsSets.stream()
                .map(set -> set.stream()
                        .map(S::lastIndexOf)
                        .max(Integer::compareTo)
                        .get())
                .collect(Collectors.toList());

        ArrayList<Integer> sizes = new ArrayList<>();
        if (!lastIndexes.isEmpty()) {
            sizes.add(lastIndexes.get(0) + 1);
        }
        for (int i = 0; i < lastIndexes.size() - 1; ++i) {
            sizes.add(lastIndexes.get(i + 1) - lastIndexes.get(i));
        }

        return sizes;
    }
}