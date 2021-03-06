package org.kiirun.joda.beans.model;

import java.util.Map;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import org.kiirun.joda.beans.base.BaseBean;

@BeanDefinition
public class Book extends BaseBean implements Bean {
	@PropertyDefinition
	private Isbn isbn;

	@PropertyDefinition
	private String name;

	@PropertyDefinition
	private Author author;

	@PropertyDefinition
	private int pages;

	public Book() {
		super();
	}

	public Book( final Isbn isbn, final String name, final Author author, final int pages ) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.pages = pages;
	}

	@Override
	public String getDisplayName() {
		return name;
	}

	// @formatter:off
    //------------------------- AUTOGENERATED START -------------------------
    /**
     * The meta-bean for {@code Book}.
     * @return the meta-bean, not null
     */
    public static Book.Meta meta() {
        return Book.Meta.INSTANCE;
    }

    static {
        MetaBean.register(Book.Meta.INSTANCE);
    }

    @Override
    public Book.Meta metaBean() {
        return Book.Meta.INSTANCE;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the isbn.
     * @return the value of the property
     */
    public Isbn getIsbn() {
        return isbn;
    }

    /**
     * Sets the isbn.
     * @param isbn  the new value of the property
     */
    public void setIsbn(Isbn isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets the the {@code isbn} property.
     * @return the property, not null
     */
    public final Property<Isbn> isbn() {
        return metaBean().isbn().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the name.
     * @return the value of the property
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * @param name  the new value of the property
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the the {@code name} property.
     * @return the property, not null
     */
    public final Property<String> name() {
        return metaBean().name().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the author.
     * @return the value of the property
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Sets the author.
     * @param author  the new value of the property
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Gets the the {@code author} property.
     * @return the property, not null
     */
    public final Property<Author> author() {
        return metaBean().author().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the pages.
     * @return the value of the property
     */
    public int getPages() {
        return pages;
    }

    /**
     * Sets the pages.
     * @param pages  the new value of the property
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * Gets the the {@code pages} property.
     * @return the property, not null
     */
    public final Property<Integer> pages() {
        return metaBean().pages().createProperty(this);
    }

    //-----------------------------------------------------------------------
    @Override
    public Book clone() {
        return JodaBeanUtils.cloneAlways(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            Book other = (Book) obj;
            return JodaBeanUtils.equal(getIsbn(), other.getIsbn()) &&
                    JodaBeanUtils.equal(getName(), other.getName()) &&
                    JodaBeanUtils.equal(getAuthor(), other.getAuthor()) &&
                    (getPages() == other.getPages());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(getIsbn());
        hash = hash * 31 + JodaBeanUtils.hashCode(getName());
        hash = hash * 31 + JodaBeanUtils.hashCode(getAuthor());
        hash = hash * 31 + JodaBeanUtils.hashCode(getPages());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(160);
        buf.append("Book{");
        int len = buf.length();
        toString(buf);
        if (buf.length() > len) {
            buf.setLength(buf.length() - 2);
        }
        buf.append('}');
        return buf.toString();
    }

    protected void toString(StringBuilder buf) {
        buf.append("isbn").append('=').append(JodaBeanUtils.toString(getIsbn())).append(',').append(' ');
        buf.append("name").append('=').append(JodaBeanUtils.toString(getName())).append(',').append(' ');
        buf.append("author").append('=').append(JodaBeanUtils.toString(getAuthor())).append(',').append(' ');
        buf.append("pages").append('=').append(JodaBeanUtils.toString(getPages())).append(',').append(' ');
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code Book}.
     */
    public static class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code isbn} property.
         */
        private final MetaProperty<Isbn> isbn = DirectMetaProperty.ofReadWrite(
                this, "isbn", Book.class, Isbn.class);
        /**
         * The meta-property for the {@code name} property.
         */
        private final MetaProperty<String> name = DirectMetaProperty.ofReadWrite(
                this, "name", Book.class, String.class);
        /**
         * The meta-property for the {@code author} property.
         */
        private final MetaProperty<Author> author = DirectMetaProperty.ofReadWrite(
                this, "author", Book.class, Author.class);
        /**
         * The meta-property for the {@code pages} property.
         */
        private final MetaProperty<Integer> pages = DirectMetaProperty.ofReadWrite(
                this, "pages", Book.class, Integer.TYPE);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "isbn",
                "name",
                "author",
                "pages");

        /**
         * Restricted constructor.
         */
        protected Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 3241718:  // isbn
                    return isbn;
                case 3373707:  // name
                    return name;
                case -1406328437:  // author
                    return author;
                case 106426308:  // pages
                    return pages;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends Book> builder() {
            return new DirectBeanBuilder<>(new Book());
        }

        @Override
        public Class<? extends Book> beanType() {
            return Book.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code isbn} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Isbn> isbn() {
            return isbn;
        }

        /**
         * The meta-property for the {@code name} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String> name() {
            return name;
        }

        /**
         * The meta-property for the {@code author} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Author> author() {
            return author;
        }

        /**
         * The meta-property for the {@code pages} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Integer> pages() {
            return pages;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 3241718:  // isbn
                    return ((Book) bean).getIsbn();
                case 3373707:  // name
                    return ((Book) bean).getName();
                case -1406328437:  // author
                    return ((Book) bean).getAuthor();
                case 106426308:  // pages
                    return ((Book) bean).getPages();
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 3241718:  // isbn
                    ((Book) bean).setIsbn((Isbn) newValue);
                    return;
                case 3373707:  // name
                    ((Book) bean).setName((String) newValue);
                    return;
                case -1406328437:  // author
                    ((Book) bean).setAuthor((Author) newValue);
                    return;
                case 106426308:  // pages
                    ((Book) bean).setPages((Integer) newValue);
                    return;
            }
            super.propertySet(bean, propertyName, newValue, quiet);
        }

    }

    //-------------------------- AUTOGENERATED END --------------------------
    // @formatter:on
}
