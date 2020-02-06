package io.prestosql.plugin.csv;

import io.prestosql.plugin.jdbc.JdbcPlugin;
/**
 * @author Ram PAsupula
 * @version 1.0
 * @since 2020-01-06
 */

public class CsvPlugin extends JdbcPlugin {
	public CsvPlugin() {
		super("csv", new CsvClientModule());
	}
}
