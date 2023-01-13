package com.tmp.base.biz.service;

import java.util.List;

public interface IfDishSearcher {
    public List<String> searchHighCalorieDishNames(int maxSize);

    public List<String> searchHealthyDishNames();
}
