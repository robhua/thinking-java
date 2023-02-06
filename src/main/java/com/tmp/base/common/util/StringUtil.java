package com.tmp.base.common.util;

import java.util.Collection;
import java.util.Iterator;

public class StringUtil {
    /**
     * {@code collection}の各要素を{@code delimiter}で区切った文字列を返す。
     * <p>
     * {@code collection}の各要素の文字列は{@code toString()}メソッドを呼んで取得する。
     * また、{@code delimiterがnull}の場合は区切り文字はないものとして処理する。
     *
     * @param collection 各要素
     * @param delimiter 区切り文字
     * @return {@code collection}の各要素を{@code delimiter}で区切った文字列
     * @throws NullPointerException {@code collection}が{@code null}の場合
     */
    public static <E> String join(Collection<E> collection, String delimiter) {
        String _delim = (delimiter == null) ? "" : delimiter;
        StringBuilder _builder = new StringBuilder(collection.size() * 2);
        for (Iterator<E> _iterator = collection.iterator(); _iterator.hasNext();) {
            E _elem = _iterator.next();
            _builder.append(_elem.toString());
            if (_iterator.hasNext()) {
                _builder.append(_delim);
            }
        }
        return _builder.toString();
    }
}
