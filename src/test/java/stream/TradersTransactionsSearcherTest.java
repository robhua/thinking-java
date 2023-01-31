package stream;

import com.tmp.base.biz.service.IfTradersTransactionsSearcher;
import com.tmp.base.domain.Trader;
import com.tmp.base.domain.Transaction;
import com.tmp.base.searcher.BaseSearcherLocator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TradersTransactionsSearcherTest {
    @Test
    public void testFindTransactionsAndSortByValue() {
        IfTradersTransactionsSearcher transactionsSearcher = BaseSearcherLocator.lookup(IfTradersTransactionsSearcher.class);

        int year = 2011;
        List<Transaction> transactions = transactionsSearcher.findTransactionsAndSortByValue(year);
        assertEquals(year, transactions.get(0).getYear());
        assertEquals(300, transactions.get(0).getValue());

        assertEquals(year, transactions.get(1).getYear());
        assertEquals(400, transactions.get(1).getValue());
    }

    @Test
    public void testAllUniqueCityWhereTraderWork() {
        IfTradersTransactionsSearcher transactionsSearcher = BaseSearcherLocator.lookup(IfTradersTransactionsSearcher.class);

        List<String> _allUniqueCities = transactionsSearcher.findAllUniqueCities();
        assertEquals(Arrays.asList("Cambridge", "Milan"), _allUniqueCities);
    }

    @Test
    public void testFindTraderByCitySortByName() {
        IfTradersTransactionsSearcher transactionsSearcher = BaseSearcherLocator.lookup(IfTradersTransactionsSearcher.class);

        String city = "Cambridge";
        List<Trader> _traders = transactionsSearcher.findTraderByCityAndSortByName(city);
        assertEquals("Alan", _traders.get(0).getName());
        assertEquals("Brian", _traders.get(1).getName());
        assertEquals("Raoul", _traders.get(2).getName());
    }

    @Test
    public void testFindAllTraderNamesSortedByName() {
        IfTradersTransactionsSearcher transactionsSearcher = BaseSearcherLocator.lookup(IfTradersTransactionsSearcher.class);

        String _tradersStr = transactionsSearcher.findAllTraderNameSortedByName();
        assertEquals("AlanBrianMarioRaoul", _tradersStr);
    }

    @Test
    public void tesTraderBasedCity() {
        IfTradersTransactionsSearcher transactionsSearcher = BaseSearcherLocator.lookup(IfTradersTransactionsSearcher.class);

        String city = "Milan";
        boolean _milanBased = transactionsSearcher.isTraderBasedCity(city);
        assertEquals(true, _milanBased);
    }
    }


}
