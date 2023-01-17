package com.tmp.base.biz.service;

import java.util.List;

public interface IfDishSearcher {
    List<String> searchHighCalorieDishNames(int maxSize);

    List<String> searchHealthyDishNames();

    List<Integer> searchDishNameLengths();

    long numberDishs();
}
