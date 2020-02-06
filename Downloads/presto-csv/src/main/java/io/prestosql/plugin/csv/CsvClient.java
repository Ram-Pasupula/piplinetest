package io.prestosql.plugin.csv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;

import io.prestosql.plugin.jdbc.BaseJdbcClient;
import io.prestosql.plugin.jdbc.BaseJdbcConfig;
import io.prestosql.plugin.jdbc.ConnectionFactory;
import io.prestosql.plugin.jdbc.StatsCollecting;
import io.prestosql.spi.type.TypeManager;
/**
 * @author Ram Pasupula
 * @version 1.0
 * @since 2020-01-06
 */
public class CsvClient extends BaseJdbcClient {

	@Inject
	public CsvClient(BaseJdbcConfig config, CsvConfig csvConfig, @StatsCollecting ConnectionFactory connectionFactory,
			TypeManager typeManager) {
		super(config, "\"", connectionFactory);
	}

	@Override
	public PreparedStatement getPreparedStatement(Connection connection, String sql) throws SQLException {
		connection.setAutoCommit(false);
		PreparedStatement statement = connection.prepareStatement(sql);
		return statement;
	}

}
