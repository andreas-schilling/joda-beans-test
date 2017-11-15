package org.kiirun.joda.beans.model;

import java.util.List;
import java.util.Objects;

import org.joda.beans.Bean;
import org.joda.beans.MetaProperty;

import com.google.common.base.MoreObjects.ToStringHelper;

public class Key<T extends Bean> {
	private final List<MetaProperty<?>> keyProperties;

	private final T bean;

	private Key( final List<MetaProperty<?>> keyProperties, final T bean ) {
		super();
		this.keyProperties = keyProperties;
		this.bean = bean;
	}

	public static <T extends Bean> KeyDefinition<T> with( final List<MetaProperty<?>> keyProperties ) {
		return new KeyDefinition<T>() {
			@Override
			public Key<T> buildFor( final T bean ) {
				return new Key<>( keyProperties, bean );
			}
		};
	}

	@Override
	public int hashCode() {
		int result = 1;

		for ( final MetaProperty<?> property : keyProperties ) {
			final Object value = property.get( bean );
			result = 31 * result + (value == null ? 0 : value.hashCode());
		}

		return result;
	}

	@SuppressWarnings( "unchecked" )
	@Override
	public boolean equals( final Object other ) {
		if ( this == other ) {
			return true;
		}
		if ( other == null ) {
			return false;
		}
		if ( getClass() != other.getClass() ) {
			return false;
		}
		for ( final MetaProperty<?> property : keyProperties ) {
			if ( !Objects.equals( property.get( bean ), property.get( ((Key<T>) other).bean ) ) ) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		final ToStringHelper toStringHelper = com.google.common.base.MoreObjects.toStringHelper( this );
		for ( final MetaProperty<?> property : keyProperties ) {
			toStringHelper.add( property.name(), property.get( bean ) );
		}
		return toStringHelper.toString();
	}

	public interface KeyDefinition<T extends Bean> {
		Key<T> buildFor( T bean );
	}
}
