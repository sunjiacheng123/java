package com.sun.study;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Log4jStudyApplicationTests {

	private static final Logger LOGGER= LogManager.getLogger(Log4jStudyApplicationTests.class);
	@Test
	void contextLoads() {
		LOGGER.fatal("fatal");
		LOGGER.error("error");
		LOGGER.debug("debug");

	}

}
