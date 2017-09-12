package org.kiirun.joda.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

@BeanDefinition
public class Author implements Bean {
    @PropertyDefinition
    private String firstName;

    @PropertyDefinition
    private String lastName;

    @PropertyDefinition
    private final List<Book> books = new ArrayList<>();

    public Author() {
        super();
    }

    public Author(final String firstName, final String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code Author}.
     * @return the meta-bean, not null
     */
    public static Author.Meta meta() {
        return Author.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(Author.Meta.INSTANCE);
    }

    @Override
    public Author.Meta metaBean() {
        return Author.Meta.INSTANCE;
    }

    @Override
    public <R> Property<R> property(String propertyName) {
        return metaBean().<R>metaProperty(propertyName).createProperty(this);
    }

    @Override
    public Set<String> propertyNames() {
        return metaBean().metaPropertyMap().keySet();
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the firstName.
     * @return the value of the property
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the firstName.
     * @param firstName  the new value of the property
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the the {@code firstName} property.
     * @return the property, not null
     */
    public final Property<String> firstName() {
        return metaBean().firstName().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the lastName.
     * @return the value of the property
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the lastName.
     * @param lastName  the new value of the property
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the the {@code lastName} property.
     * @return the property, not null
     */
    public final Property<String> lastName() {
        return metaBean().lastName().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the books.
     * @return the value of the property, not null
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Sets the books.
     * @param books  the new value of the property, not null
     */
    public void setBooks(List<Book> books) {
        JodaBeanUtils.notNull(books, "books");
        this.books.clear();
        this.books.addAll(books);
    }

    /**
     * Gets the the {@code books} property.
     * @return the property, not null
     */
    public final Property<List<Book>> books() {
        return metaBean().books().createProperty(this);
    }

    //-----------------------------------------------------------------------
    @Override
    public Author clone() {
        return JodaBeanUtils.cloneAlways(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            Author other = (Author) obj;
            return JodaBeanUtils.equal(getFirstName(), other.getFirstName()) &&
                    JodaBeanUtils.equal(getLastName(), other.getLastName()) &&
                    JodaBeanUtils.equal(getBooks(), other.getBooks());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(getFirstName());
        hash = hash * 31 + JodaBeanUtils.hashCode(getLastName());
        hash = hash * 31 + JodaBeanUtils.hashCode(getBooks());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(128);
        buf.append("Author{");
        int len = buf.length();
        toString(buf);
        if (buf.length() > len) {
            buf.setLength(buf.length() - 2);
        }
        buf.append('}');
        return buf.toString();
    }

    protected void toString(StringBuilder buf) {
        buf.append("firstName").append('=').append(JodaBeanUtils.toString(getFirstName())).append(',').append(' ');
        buf.append("lastName").append('=').append(JodaBeanUtils.toString(getLastName())).append(',').append(' ');
        buf.append("books").append('=').append(JodaBeanUtils.toString(getBooks())).append(',').append(' ');
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code Author}.
     */
    public static class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code firstName} property.
         */
        private final MetaProperty<String> firstName = DirectMetaProperty.ofReadWrite(
                this, "firstName", Author.class, String.class);
        /**
         * The meta-property for the {@code lastName} property.
         */
        private final MetaProperty<String> lastName = DirectMetaProperty.ofReadWrite(
                this, "lastName", Author.class, String.class);
        /**
         * The meta-property for the {@code books} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<List<Book>> books = DirectMetaProperty.ofReadWrite(
                this, "books", Author.class, (Class) List.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "firstName",
                "lastName",
                "books");

        /**
         * Restricted constructor.
         */
        protected Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 132835675:  // firstName
                    return firstName;
                case -1459599807:  // lastName
                    return lastName;
                case 93921962:  // books
                    return books;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends Author> builder() {
            return new DirectBeanBuilder<Author>(new Author());
        }

        @Override
        public Class<? extends Author> beanType() {
            return Author.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code firstName} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String> firstName() {
            return firstName;
        }

        /**
         * The meta-property for the {@code lastName} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String> lastName() {
            return lastName;
        }

        /**
         * The meta-property for the {@code books} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<List<Book>> books() {
            return books;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 132835675:  // firstName
                    return ((Author) bean).getFirstName();
                case -1459599807:  // lastName
                    return ((Author) bean).getLastName();
                case 93921962:  // books
                    return ((Author) bean).getBooks();
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 132835675:  // firstName
                    ((Author) bean).setFirstName((String) newValue);
                    return;
                case -1459599807:  // lastName
                    ((Author) bean).setLastName((String) newValue);
                    return;
                case 93921962:  // books
                    ((Author) bean).setBooks((List<Book>) newValue);
                    return;
            }
            super.propertySet(bean, propertyName, newValue, quiet);
        }

        @Override
        protected void validate(Bean bean) {
            JodaBeanUtils.notNull(((Author) bean).books, "books");
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}
