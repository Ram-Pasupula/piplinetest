package com.facebook.presto.plugin.csv;

import io.airlift.configuration.Config;

/**
 * @author Ram Pasupula
 * @version 325
 * @since 2020-02-10
 */

public class CsvConfig {
	
	private String charset = "UTF-8";
	private String separator = ",";

	public String getSeparator() {
		return separator;
	}

	@Config("separator")
	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getCharset() {
		return charset;
	}

	@Config("charset")
	public void setCharset(String charset) {
		this.charset = charset;
	}
}
