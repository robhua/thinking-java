package com.tmp.base.searcher;

import java.util.ArrayList;
import java.util.List;

/**
 * <H3>
 *  Repository of Searcher implementations.
 * </H3>
 *
 * This implementation loads <code>com.nsk.ras.base.service/resources.base/com/nsk/ras/base/searcher/BaseSearchers.properties</code>.
 *
 * property file must contains set of "interface class name" and "implementation class name".
 * "{interface class}" = "{implements class}"
 *
 *  * priority setting: set system property"com.nsk.ras.system.searchers.config"
 *  example: -Dcom.nsk.ras.system.searchers.config=stub.searchers
 *  for such configuration, <code>stub/searchers.properties</code> will be available.
 *  *
 *
 */
public class BaseSearcherLocator extends AbstractSearcherLocator {
    private static final List<String> BUNDLE_LIST = loadBundleList(loadBasePropertyNameList());
    public static <T> T lookup(Class<T> interfaceClass) {
        T _searcher = lookup(interfaceClass, BUNDLE_LIST);
        return _searcher;
    }
    /**
     * Load BasePropertyNameList.<br>
     * @return The List of class name in config file.
     */
    protected static List<String> loadBasePropertyNameList() {

        List<String> _nameList = new ArrayList<String>();
//        String _propertyName = System.getProperty(SYSTEM_PROPERTY_CONFIG_FILE);
//        if (null == _propertyName) {
//            _propertyName = DEFAULT_PROPERTY_FILE;
//        }
//        _nameList.add(_propertyName);
        return _nameList;
    }
}
