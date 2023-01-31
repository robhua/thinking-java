package com.tmp.base.biz.service.impl;

import com.tmp.base.biz.service.IfDishSearcher;
import com.tmp.base.domain.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DishSearcher implements IfDishSearcher {
    private static final int HEALTHY_CALORIE = 400;
    private static final int HIGH_CALORIE = 300;

    private static final List<Dish> menu = createMenu();

    public List<String> searchHighCalorieDishNames(int maxSize) {
        return menu.stream().filter(dish -> dish.getCalories() > HIGH_CALORIE)
                            .map(Dish::getName)
                            .limit(maxSize)
                            .collect(toList());
    }

    public List<String> searchHealthyDishNames(){
        return menu.stream().filter(dish -> dish.getCalories() < HEALTHY_CALORIE)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }

    @Override
    public List<Integer> searchDishNameLengths() {
        return menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
    }

    @Override
    public long numberDishs() {
        return menu.stream().count();
    }

    private static List<Dish> createMenu() {
        return Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
    }
}
