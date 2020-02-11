package com.facebook.presto.plugin.csv;

import io.prestosql.plugin.jdbc.JdbcPlugin;

/**
 * @author RAM PASUPULA
 * @version 325
 * @since 2020-02-10
 */

public class CsvPlugin extends JdbcPlugin {
	public CsvPlugin() {
		super("csv", new CsvClientModule());
	}
}
