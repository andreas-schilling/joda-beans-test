package org.kiirun.joda.beans.base;

import org.joda.beans.Bean;
import org.joda.beans.MetaProperty;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

public class PropertyFunctions {
    public static <T extends Bean, R> Function<T, R> extract( final MetaProperty<R> property ) {
        return ( final T bean ) -> property.get( bean );
    }

    public static <T extends Bean, R extends Comparable<R>> Ordering<T> sortBy( final MetaProperty<R> property ) {
        return Ordering.natural().onResultOf( extract( property ) );
    }
}
