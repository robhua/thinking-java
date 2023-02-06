package stream;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class Java8FindAnyFindFirstUnitTest {
    @Test
    public void createStream_whenFindAnyResultIsPresent_thenCorrect() {

        List<String> list = Arrays.asList("A", "B", "C", "D");

        Optional<String> result = list.stream().findAny();

        assertThat(result.get(), anyOf(is("A"), is("B"), is("C"), is("D")));
    }

    @Test
    public void createFlatteningStream() {

        String[] arrayOfWords = {"Goodbye", "World"};

        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);

        List<String> uniqueCharacters = streamOfwords.map(w -> w.split(""))
                                                    .flatMap(Arrays::stream)
                                                    .distinct()
                                                    .collect(Collectors.toList());

        System.out.println(uniqueCharacters);
    }


    @Test
    public void createStream_whenFindFristSquareDivisibleByThree_thenCorrect() {

        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);

        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                                .map(x -> x*x)
                                .filter(x -> x%3 == 0)
                                .findFirst();

        assertTrue(firstSquareDivisibleByThree.isPresent());
        assertEquals(9, firstSquareDivisibleByThree.get().intValue());

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

    @Test
    public void testNumericRanges() {
        Stream<double[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                                                    .flatMap(a ->
                                                            IntStream.rangeClosed(a, 100)
                                                                    .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                                                    .filter(t -> t[2] % 1 == 0)
                                                    );

//        stream.forEach(pair -> System.out.println(pair[0] + ", " + pair[1]));
        Stream<int[]> stream = IntStream.rangeClosed(1, 3)
                .mapToObj(a -> new int[]{a, 1});
//        System.out.println(pythagoreanTriples.count());
        pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

}
