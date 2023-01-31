package stream;

import com.tmp.base.biz.service.IfDishSearcher;
import com.tmp.base.searcher.BaseSearcherLocator;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DishSearcherTest {
    @Test
    public void testFindTransactionsAndSortByValue() {
        IfDishSearcher _dishSearcher = BaseSearcherLocator.lookup(IfDishSearcher.class);

        OptionalInt maxCalories = _dishSearcher.findMaxCalories();
        assertEquals(800, maxCalories.getAsInt());
    }
}
