package stream;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildStreamTest {
    @Test
    public void testStreamFromFile() {
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("src/test/resources/data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line .split("")))
                                .distinct()
                                .count();
        } catch (IOException e) {

        }

        assertEquals(8, uniqueWords);
    }
}
