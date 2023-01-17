package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class Java8FindAnyFindFirstUnitTest {
    @Test
    public void createStream_whenFindAnyResultIsPresent_thenCorrect() {

        List<String> list = Arrays.asList("A", "B", "C", "D");

        Optional<String> result = list.stream().findAny();

        assertTrue(result.isPresent());
        assertThat(result.get(), anyOf(is("A"), is("B"), is("C"), is("D")));
    }

    @Test
    public void createStream_whenFindFristSquareDivisibleByThree_thenCorrect() {

        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);

        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                                .map(x -> x*x)
                                .filter(x -> x%3 == 0)
                                .findFirst();

        assertTrue(firstSquareDivisibleByThree.isPresent() && firstSquareDivisibleByThree.get().intValue() == 9);

    }

    @Test
    public void createStream_createPairsNumbersWhoseSumDivisibleByThree() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs = numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());

        assertArrayEquals(new int[]{2, 4}, pairs.get(0));
        assertArrayEquals(new int[]{3, 3}, pairs.get(1));
    }

}
