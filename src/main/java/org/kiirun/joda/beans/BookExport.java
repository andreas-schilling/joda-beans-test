package org.kiirun.joda.beans;

import java.io.IOException;
import java.util.List;

import org.joda.beans.MetaProperty;
import org.kiirun.joda.beans.base.CustomProperties;
import org.kiirun.joda.beans.base.MetaPropertyChain;
import org.kiirun.joda.beans.model.Author;
import org.kiirun.joda.beans.model.Book;
import org.kiirun.joda.beans.model.Isbn;
import org.supercsv.prefs.CsvPreference;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class BookExport {
	private static final Book.Meta book_ = Book.meta();

	public static void main( final String[] args ) throws IOException {
		final List<Book> books = buildBooks();
		try ( CsvExporter<Book> exporter = new CsvExporter( "books1.csv", CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE ) ) {
			exporter.export( books, ImmutableList.copyOf( book_.metaPropertyMap().values() ) );
			exporter.close();
		}

		try ( CsvExporter<Book> exporter = new CsvExporter( "books2.csv", CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE ) ) {
			exporter.export( books, ImmutableList.of( book_.name(), book_.author(), book_.pages() ) );
			exporter.close();
		}

		try ( CsvExporter<Book> exporter = new CsvExporter( "books3.csv", CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE ) ) {
			final MetaProperty<String> authorName = MetaPropertyChain.of( book_.author(), CustomProperties.displayName( Author.class ) );
			exporter.export( books, ImmutableList.of( book_.name(), authorName, book_.pages() ) );
			exporter.close();
		}
	}

	private static List<Book> buildBooks() {
		final List<Book> books = Lists.newArrayList();
		final Author author1 = new Author( "Jon", "Doe" );
		final Author author2 = new Author( "Erika", "Musterfrau" );
		for ( int i = 0; i < 3; i++ ) {
			books.add( new Book( new Isbn( "12345-321-123-" + i ), "Doebook " + i, author1, 100 + (i * 10) ) );
		}
		for ( int i = 0; i < 4; i++ ) {
			books.add( new Book( new Isbn( "54321-123-321-" + i ), "Musterbook " + i, author2, 50 + (i * 20) ) );
		}
		return books;
	}
}
