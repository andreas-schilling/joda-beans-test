package org.kiirun.joda.beans;

import java.text.ChoiceFormat;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;


public class AuthorIndex {
	private static final ChoiceFormat ENTRY_FORMAT = new ChoiceFormat(new double[] { 0, 1, 2 }, new String[] { "entries", "entry", "entries" });

	public static void main(final String[] args) {
		final List<Author> authors = buildAuthors();
		printIndexStatistics(authors);
		printSortedAuthors(authors);
	}

	private static List<Author> buildAuthors() {
		return ImmutableList.of(
				Author.meta().builder().set(Author.meta().firstName(), "Henning").set(Author.meta().lastName(), "Mankell").build(),
				Author.meta().builder().set(Author.meta().firstName(), "Michael").set(Author.meta().lastName(), "Crichton").build(),
				Author.meta().builder().set(Author.meta().firstName(), "Michael").set(Author.meta().lastName(), "Ende").build());
	}

	private static void printIndexStatistics(final List<Author> authors) {
		System.out.println("Indexing by first name:");
		final Multimap<Key<Author>, Author> byFirstName =
				Multimaps.index(authors, Key.<Author> with(ImmutableList.of(Author.meta().firstName()))::buildFor);
		for (final Key<Author> authorKey : byFirstName.keySet()) {
			final Collection<Author> authorsForKey = byFirstName.get(authorKey);
			System.out.println(authorsForKey.size() + " " + ENTRY_FORMAT.format(authorsForKey.size()) + " for " + authorKey + ": " + authorsForKey);
		}

		System.out.println("\nIndexing by full name:");
		final Multimap<Key<Author>, Author> byFullName =
				Multimaps.index(authors, Key.<Author> with(ImmutableList.of(Author.meta().firstName(), Author.meta().lastName()))::buildFor);
		for (final Key<Author> authorKey : byFullName.keySet()) {
			final Collection<Author> authorsForKey = byFullName.get(authorKey);
			System.out.println(authorsForKey.size() + " " + ENTRY_FORMAT.format(authorsForKey.size()) + " for " + authorKey + ": " + authorsForKey);
		}
	}

	private static void printSortedAuthors(final List<Author> authors) {
		System.out.println("\nSorted by first name ascending:  " + PropertyFunctions.sortBy(Author.meta().firstName()).sortedCopy(authors));
		System.out.println("Sorted by first name descending: " + PropertyFunctions.sortBy(Author.meta().firstName()).reverse().sortedCopy(authors));

		System.out.println("Sorted by last name ascending:   " + PropertyFunctions.sortBy(Author.meta().lastName()).sortedCopy(authors));
		System.out.println("Sorted by last name descending:  " + PropertyFunctions.sortBy(Author.meta().lastName()).reverse().sortedCopy(authors));
	}
}
