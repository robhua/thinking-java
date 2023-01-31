package com.tmp.base.biz.service;

import java.util.List;
import java.util.OptionalInt;

public interface IfDishSearcher {
    List<String> searchHighCalorieDishNames(int maxSize);

    List<String> searchHealthyDishNames();

    List<Integer> searchDishNameLengths();

    long numberDishs();

    OptionalInt findMaxCalories();
}
