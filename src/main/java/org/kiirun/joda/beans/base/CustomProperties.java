package org.kiirun.joda.beans.base;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import org.joda.beans.Bean;
import org.joda.beans.MetaBean;
import org.joda.beans.MetaProperty;
import org.joda.beans.PropertyStyle;
import org.joda.beans.impl.BasicMetaProperty;

public class CustomProperties {
    public static <T extends BaseBean> MetaProperty<String> displayName( final Class<T> clazz ) {
        return new BasicMetaProperty<String>( "displayName" ) {

            @Override
            public MetaBean metaBean() {
                return MetaBean.of( clazz );
            }

            @Override
            public Class<?> declaringType() {
                return clazz;
            }

            @Override
            public Class<String> propertyType() {
                return String.class;
            }

            @Override
            public Type propertyGenericType() {
                return clazz;
            }

            @Override
            public PropertyStyle style() {
                return PropertyStyle.DERIVED;
            }

            @Override
            public List<Annotation> annotations() {
                return Collections.emptyList();
            }

            @Override
            public String get( Bean bean ) {
                return ((T) bean).getDisplayName();
            }

            @Override
            public void set( Bean bean, Object value ) {
                throw new UnsupportedOperationException( "Property cannot be written: " + name() );
            }
        };
    }
}
