package main.java;

import com.tmp.base.biz.service.IfDishSearcher;
import com.tmp.base.searcher.BaseSearcherLocator;
import com.tmp.base.biz.service.impl.DishSearcher;

import java.util.List;

public class TestStreams {
    private static final int HEALTHY_CALORIE = 400;
    private static final int HIGH_CALORIE = 300;

    public static void main(String[] args) {

        IfDishSearcher dishSearcher = BaseSearcherLocator.lookup(IfDishSearcher.class);

        List<String> healthyDishNames = dishSearcher.searchHealthyDishNames();
        System.out.println(healthyDishNames);

        int maxSize = 3;
        List<String> highCalorieDishNames = dishSearcher.searchHighCalorieDishNames(maxSize);
        System.out.println(highCalorieDishNames);
    }
}
