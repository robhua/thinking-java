package com.tmp.base.searcher;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * <H3>
 * Repository of Searcher implementations.
 * </H3>
 * <p>
 * property file must contains set of "interface class name" and "implementation class name".
 * "{interface class}" = "{implements class}"
 */
public abstract class AbstractSearcherLocator {
    /**
     * lookup Searcher implementation. <br>
     *
     * @param interfaceClass Class
     * @param bundleList     List
     * @return searcher object
     */
    protected static <T> T lookup(Class<T> interfaceClass, List bundleList) {
        String _interfaceClassName = interfaceClass.getName();
        String _searcherClassName = findClassName(_interfaceClassName, bundleList);

        try {
            T _searcher = (T) Class.forName(_searcherClassName).newInstance();
            return _searcher;
        } catch (Exception e) {
            throw new RuntimeException("E00008", e);
        }
    }

    /**
     * load ResourceBundle to resolve finder class name.
     *
     * @param bundleNameList List of ResourceBundle
     * @return loaded ResourceBundle
     */
    protected static final List loadBundleList(List bundleNameList) {
        List _bundleList = new ArrayList();
        for (int i = 0; i < bundleNameList.size(); i++) {
            String _bundleName = (String) bundleNameList.get(i);
            ResourceBundle _bundle = ResourceBundle.getBundle(_bundleName);
            _bundleList.add(_bundle);
        }
        return _bundleList;
    }

    //***** Private method *****

    /**
     * findClassName <br>
     *
     * @param interfaceClassName
     * @param bundleList
     * @return
     */
    private static String findClassName(String interfaceClassName, List bundleList) {
        //TODO findClassName from bundle list
        String _dish = "com.tmp.base.biz.service.impl.DishSearcher";
        String _transaction = "com.tmp.base.biz.service.impl.TradersTransactionsSearcher";
        if (interfaceClassName.contains("DishSearcher")) {
            return _dish;
        } else if (interfaceClassName.contains("com.tmp.base.biz.service.IfTradersTransactionsSearcher")) {
            return _transaction;
        }
        return _dish;
    }
}
