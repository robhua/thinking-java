package com.tmp.base.biz.service.impl;

import com.tmp.base.biz.service.IfTradersTransactionsSearcher;
import com.tmp.base.domain.Trader;
import com.tmp.base.domain.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TradersTransactionsSearcher implements IfTradersTransactionsSearcher {
    static final List<Transaction> transactions = getAllTransactions();

    private static List<Transaction> getAllTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));
    }

    @Override
    public List<Transaction> findTransactionsAndSortByValue(int year) {
        return transactions.stream()
                            .filter(transaction -> transaction.getYear() == year)
                            .sorted(Comparator.comparing(Transaction::getValue))
                            .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllUniqueCities() {
        return transactions.stream()
                            .map(transaction -> transaction.getTrader().getCity())
                            .distinct()
                            .collect(Collectors.toList());
    }

    @Override
    public List<Trader> findTraderByCityAndSortByName(String city) {
        return transactions.stream()
                            .map(Transaction::getTrader)
                            .filter(trader -> city.equals(trader.getCity()))
                            .distinct()
                            .sorted(Comparator.comparing(Trader::getName))
                            .collect(Collectors.toList());
    }

    @Override
    public String findAllTraderNameSortedByName() {
        return transactions.stream()
                            .map(transaction -> transaction.getTrader().getName())
                            .distinct()
                            .sorted()
                            .collect(Collectors.joining());// efficient solution that makes use of a StringBuilder
            //                .reduce("", (n1, n2) -> n1 + n2); // isn't very efficient, all String are repeatedly concatenated, which creates a new String() object at each iteration
    }

    @Override
    public boolean isTraderBasedCity(String city) {
        return transactions.stream()
                           .anyMatch(transaction -> transaction.getTrader()
                                                                .getCity()
                                                                .equals(city));
    }
}
