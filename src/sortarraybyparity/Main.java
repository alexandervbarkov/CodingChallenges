package sortarraybyparity;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public int[] sortArrayByParity(int[] A) {
        List<Integer> odds = new LinkedList<>();
        List<Integer> evens = new LinkedList<>();
        IntStream.of(A)
                .forEach(i -> {
                    if (i % 2 == 0) evens.add(i);
                    else odds.add(i);
                });
        evens.addAll(odds);
        return evens.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
