package com.tmp.base.searcher;

import com.tmp.base.common.exceptions.ApplicationLogicException;
import com.tmp.base.mid.java.constants.SystemErrorCodeConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
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

        String _searcherClassName = null;
        try {
            _searcherClassName = findClassName(_interfaceClassName, bundleList);
        } catch (MissingResourceException e) {
            IllegalStateException _baseException = new IllegalStateException("searcher for " + _interfaceClassName + " is not defined.");
            throw new ApplicationLogicException(SystemErrorCodeConstants.ERROR_LOGIC, _baseException);
        }

        try {
            T _searcher = (T) Class.forName(_searcherClassName).newInstance();
            return _searcher;
        } catch (Exception e) {
            throw new ApplicationLogicException(SystemErrorCodeConstants.ERROR_LOGIC, e);
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
        String _className = null;
        MissingResourceException _e = null;

        // loop for list of ResourceBundle
        for (int i = 0; i < bundleList.size(); i++) {
            try {
                ResourceBundle _bundle = (ResourceBundle) bundleList.get(i);
                _className = (String) _bundle.getString(interfaceClassName);
            } catch (MissingResourceException e) {
                _e = e;
            }
        }

        // case of missing resource
        if (_className == null) {
            throw _e;
        }
        return _className;
    }
}
