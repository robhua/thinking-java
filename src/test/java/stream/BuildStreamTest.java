package stream;

import com.tmp.base.common.constants.SystemErrorCodeConstants;
import com.tmp.base.common.exceptions.ApplicationLogicException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildStreamTest {
    private static final String PATTERN_DATE      = "yyyy/MM/dd";

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

    @Test
    public void testCreateStreamFromFunction() {

        Stream.iterate(new int[] {0, 1},
                        t -> new int[] {t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        final SimpleDateFormat format = new SimpleDateFormat(PATTERN_DATE);
        final Calendar calendar = Calendar.getInstance();
        String currentDate = "2023/02/04";
        Stream.iterate(currentDate,
                        curDate -> {
                            calendar.setTime(parseDate(curDate));
                            calendar.add(Calendar.DAY_OF_YEAR, 1);
                            return format.format(calendar.getTime());
                        })
                .limit(10)
                .forEach(System.out::println);
    }

    /**
     * 日付の変換を行う.<br>
     *
     * @param date String
     * @return Date
     */
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat(PATTERN_DATE).parse(date);
        } catch (ParseException e) {
            throw new ApplicationLogicException(SystemErrorCodeConstants.LOGIC, new IllegalArgumentException("Validate " + date + " before parse."));
        }
    }


}
