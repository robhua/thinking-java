import com.tmp.base.biz.service.IfDishSearcher;
import com.tmp.base.searcher.BaseSearcherLocator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStreams {

    public static void main(String[] args) {

        IfDishSearcher dishSearcher = BaseSearcherLocator.lookup(IfDishSearcher.class);

        List<String> healthyDishNames = dishSearcher.searchHealthyDishNames();
        System.out.println(healthyDishNames);

        int maxSize = 3;
        List<String> highCalorieDishNames = dishSearcher.searchHighCalorieDishNames(maxSize);
        System.out.println(highCalorieDishNames);

        List<Integer> dishNameLengths = dishSearcher.searchDishNameLengths();
        System.out.println(dishNameLengths);

        long numberOfDish = dishSearcher.numberDishs();
        System.out.println(numberOfDish);

        List<String> words = Arrays.asList("Hello", "world");
        List<String> collect = words.stream()
                                        .map(word -> word.split(""))
                                        .flatMap(Arrays::stream)
                                        .distinct()
                                        .collect(Collectors.toList());
        System.out.println(collect);

    }
}
