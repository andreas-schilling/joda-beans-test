package org.kiirun.joda.beans;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.beans.Bean;
import org.joda.beans.MetaProperty;
import org.supercsv.io.AbstractCsvWriter;
import org.supercsv.prefs.CsvPreference;

public class CsvExporter<T extends Bean> extends AbstractCsvWriter {

	public CsvExporter( final String fileName, final CsvPreference preference ) throws IOException {
		super( new FileWriter( fileName ), preference );
	}

	public void export( final Collection<T> toExport,
			final List<MetaProperty<?>> propertiesToExport ) throws IOException {
		final List<String> headerNames = propertiesToExport.stream()
														   .map( MetaProperty::name )
														   .collect( Collectors.toList() );
		writeHeader( headerNames.toArray( new String[headerNames.size()] ) );
		for ( final T bean : toExport ) {
			write( bean, propertiesToExport );
		}
	}

	private void write( final T source, final List<MetaProperty<?>> propertiesToExport ) throws IOException {
		super.incrementRowAndLineNo();
		super.writeRow( propertiesToExport.stream()
										  .map( property -> property.get( source ) )
										  .collect( Collectors.toList() ) );
	}
}
