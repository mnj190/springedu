package com.kh.portpolio;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DBconnection {
	private static final Logger logger = LoggerFactory.getLogger(DBconnection.class);

	@Inject
	DataSource dataSource;

	@Inject
	JdbcTemplate jdbcTemplate;

	@Test
	void testdb() {
		logger.info("DataSource : " + dataSource);
		logger.info("JdbcTemplate : " + jdbcTemplate);

		try {
			Connection con = dataSource.getConnection();
			Assertions.assertNotNull(con);
			logger.info("DB 연결 성공");
		} catch (Exception e) {
			logger.info("DB 연결 실패");
			e.printStackTrace();
		}
	}

}