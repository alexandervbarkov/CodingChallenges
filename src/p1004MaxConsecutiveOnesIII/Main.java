package p1004MaxConsecutiveOnesIII;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        int[] array = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
//        System.out.println(new Main().longestOnes(array, 2));
//        int[] array = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
//        System.out.println(new Main().longestOnes(array, 3));
        int[] array = {1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
        System.out.println(new Main().longestOnes(array, 8));
    }

    public int longestOnes(int[] A, int K) {
        List<Integer> startingIndexes = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        boolean indexSet = false;
        int count = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == 1) {
                if (!indexSet) {
                    startingIndexes.add(i);
                    indexSet = true;
                }
                count++;
            } else {
                if (count > 0) {
                    counts.add(count);
                    count = 0;
                    indexSet = false;
                }
            }
        }
        if (A[A.length - 1] == 1) counts.add(count);

        int max = 0;
        int swaps = K;
        for (int i = 0; i < startingIndexes.size(); ++i) {
            count = counts.get(i);
            int j = i + 1;
            boolean swapUsed = false;
            while (j < startingIndexes.size()) {
                if (swaps >= startingIndexes.get(j) - (startingIndexes.get(j - 1) + counts.get(j - 1) - 1) - 1) {
                    count = (startingIndexes.get(j) + counts.get(j)) - startingIndexes.get(i);
                    swapUsed = true;
                } else {
                    if(!swapUsed) {
                        count = A.length - (count + swaps) >= 0 ? count + swaps : A.length;
                    }
                    swapUsed = true;
                    break;
                }
                swaps -= startingIndexes.get(j) - (startingIndexes.get(i) + counts.get(i));
                ++j;
            }
            if(!swapUsed) {
                count = A.length - (count + swaps) >= 0 ? count + swaps : A.length;
            }
            if (count > max) max = count;
            swaps = K;
        }

        return max;
    }
}
