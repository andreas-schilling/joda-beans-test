package org.kiirun.joda.beans.base;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.beans.Bean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyStyle;
import org.joda.beans.impl.BasicProperty;
import org.joda.convert.StringConvert;

public class MetaPropertyChain<P> implements MetaProperty<P> {

    private final List<MetaProperty<? extends Bean>> chain;

    private final MetaProperty<P> last;

    private final List<MetaProperty<?>> completeChain;

    public static <P> MetaPropertyChain<P> of( MetaProperty<? extends Bean> prop1, MetaProperty<P> prop2 ) {
        if ( prop1 == null || prop2 == null ) {
            throw new NullPointerException( "MetaProperty must not be null" );
        }
        List<MetaProperty<? extends Bean>> list = Collections.<MetaProperty<? extends Bean>> singletonList( prop1 );
        return new MetaPropertyChain<P>( list, prop2 );
    }

    public static <P> MetaPropertyChain<P> of( MetaProperty<? extends Bean> prop1, MetaProperty<? extends Bean> prop2,
            MetaProperty<P> prop3 ) {
        if ( prop1 == null || prop2 == null || prop3 == null ) {
            throw new NullPointerException( "MetaProperty must not be null" );
        }
        List<MetaProperty<? extends Bean>> list = new ArrayList<MetaProperty<? extends Bean>>();
        list.add( prop1 );
        list.add( prop2 );
        return new MetaPropertyChain<P>( list, prop3 );
    }

    public static <P> MetaPropertyChain<P> of( MetaProperty<? extends Bean> prop1, MetaProperty<? extends Bean> prop2,
            MetaProperty<? extends Bean> prop3, MetaProperty<P> prop4 ) {
        if ( prop1 == null || prop2 == null || prop3 == null || prop4 == null ) {
            throw new NullPointerException( "MetaProperty must not be null" );
        }
        List<MetaProperty<? extends Bean>> list = new ArrayList<>();
        list.add( prop1 );
        list.add( prop2 );
        list.add( prop3 );
        return new MetaPropertyChain<>( list, prop4 );
    }

    private MetaPropertyChain( List<MetaProperty<? extends Bean>> metaProperties, MetaProperty<P> last ) {
        this.chain = metaProperties;
        this.last = last;
        this.completeChain = new ArrayList<>( chain );
        completeChain.add( last );
    }

    @Override
    public Property<P> createProperty( Bean bean ) {
        return BasicProperty.of( bean, this );
    }

    @Override
    public MetaBean metaBean() {
        return chain.get( 0 ).metaBean();
    }

    @Override
    public String name() {
        return toString();
    }

    @Override
    public Class<?> declaringType() {
        return metaBean().beanType();
    }

    @Override
    public Class<P> propertyType() {
        return last.propertyType();
    }

    @Override
    public Type propertyGenericType() {
        return last.propertyGenericType();
    }

    @Override
    public PropertyStyle style() {
        return last.style();
    }

    @Override
    public List<Annotation> annotations() {
        return last.annotations();
    }

    @Override
    public <A extends Annotation> A annotation( Class<A> annotation ) {
        return last.annotation( annotation );
    }

    @Override
    public P get( Bean bean ) {
        return last.get( resolveLastBean( bean ) );
    }

    private Bean resolveLastBean( Bean bean ) {
        for ( MetaProperty<? extends Bean> mp : chain ) {
            bean = mp.get( bean );
        }
        return bean;
    }

    @Override
    public void set( Bean bean, Object value ) {
        last.set( resolveLastBean( bean ), value );
    }

    @Override
    public P put( Bean bean, Object value ) {
        return last.put( resolveLastBean( bean ), value );
    }

    @Override
    public String getString( Bean bean ) {
        return getString( bean, JodaBeanUtils.stringConverter() );
    }

    @Override
    public String getString( Bean bean, StringConvert stringConvert ) {
        P value = get( bean );
        return stringConvert.convertToString( propertyType(), value );
    }

    @Override
    public void setString( Bean bean, String value ) {
        setString( bean, value, JodaBeanUtils.stringConverter() );
    }

    @Override
    public void setString( Bean bean, String value, StringConvert stringConvert ) {
        set( bean, stringConvert.convertFromString( propertyType(), value ) );
    }

    public List<MetaProperty<?>> getChain() {
        return Collections.unmodifiableList( completeChain );
    }

    @Override
    public String toString() {
        return completeChain.stream().map( MetaProperty::name ).collect( Collectors.joining( "." ) );
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj instanceof MetaProperty<?> ) {
            MetaProperty<?> other = (MetaProperty<?>) obj;
            return name().equals( other.name() ) && declaringType().equals( other.declaringType() );
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name().hashCode() ^ declaringType().hashCode();
    }
}
