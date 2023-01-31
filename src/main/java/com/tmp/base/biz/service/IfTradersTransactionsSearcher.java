package com.tmp.base.biz.service;

import com.tmp.base.domain.Trader;
import com.tmp.base.domain.Transaction;

import java.util.List;

public interface IfTradersTransactionsSearcher {
    List<Transaction> findTransactionsAndSortByValue(int year);

    List<String> findAllUniqueCities();

    List<Trader> findTraderByCityAndSortByName(String city);

    String findAllTraderNameSortedByName();

    boolean isTraderBasedCity(String city);
}
