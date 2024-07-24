package main.algorithms.medium;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveValuesExercise {

    public static void main(String ... args) {

        List<Integer> numbers = IntStream.range(1, 1_000_001)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        List<Integer> oddNumbers = IntStream.range(1, 1_000_001)
                .filter(number -> number % 2 == 1)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        LocalDateTime start = LocalDateTime.now();

        List<Integer> result = new ArrayList<>();
        int j = 0;
        for (Integer oddNumber : oddNumbers) {
            j++;
            if (!numbers.get(j).equals(oddNumber)) {
                result.add(numbers.get(j));
            }
            j++;
        }

        LocalDateTime end = LocalDateTime.now();

        System.out.println(result);

        System.out.println("Total time::" + ChronoUnit.SECONDS.between(start, end));
    }
}
