package io.prestosql.plugin.csv;

import static io.airlift.configuration.ConfigBinder.configBinder;

import java.sql.SQLException;
import java.util.Properties;

import org.relique.jdbc.csv.CsvDriver;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;

import io.prestosql.plugin.jdbc.BaseJdbcConfig;
import io.prestosql.plugin.jdbc.ConnectionFactory;
import io.prestosql.plugin.jdbc.DriverConnectionFactory;
import io.prestosql.plugin.jdbc.JdbcClient;
import io.prestosql.plugin.jdbc.credential.CredentialProvider;

/**
 * @author Ram PAsupula
 * @version 1.0
 * @since 2020-01-06
 */

public class CsvClientModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(JdbcClient.class).to(CsvClient.class).in(Scopes.SINGLETON);
		configBinder(binder).bindConfig(BaseJdbcConfig.class);
		configBinder(binder).bindConfig(CsvConfig.class);
	}

	@Provides
	@Singleton
	public static ConnectionFactory createConnectionFactory(BaseJdbcConfig config, CsvConfig csvConfig, CredentialProvider credentialProvider)
			throws SQLException {
		//Properties connectionProperties = basicConnectionProperties(config);
		Properties connectionProperties = new Properties();

         connectionProperties.setProperty("block size", "512");
       
		if (csvConfig.getCharset() != null) {
			 connectionProperties.setProperty("charset", csvConfig.getCharset());
		}

		if (csvConfig.getSeparator() != null) {
			connectionProperties.setProperty("separator", csvConfig.getSeparator());
		}

		
		return new DriverConnectionFactory(new CsvDriver(), config.getConnectionUrl(), connectionProperties, credentialProvider);

	}
}
