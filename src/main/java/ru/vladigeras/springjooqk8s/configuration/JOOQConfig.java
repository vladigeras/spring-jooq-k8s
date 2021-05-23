package ru.vladigeras.springjooqk8s.configuration;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListener;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
public class JOOQConfig {

	private final DataSource dataSource;

	@Bean
	public DataSourceConnectionProvider connectionProvider() {
		return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
	}

	@Bean
	public DefaultDSLContext dsl() {
		return new DefaultDSLContext(dslContextConfig());
	}

	public DefaultConfiguration dslContextConfig() {
		DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
		jooqConfiguration.set(connectionProvider());
		jooqConfiguration.setSQLDialect(SQLDialect.POSTGRES);
		jooqConfiguration.set(new DefaultExecuteListenerProvider(new DefaultExecuteListener()));
		return jooqConfiguration;
	}
}
