package com.gwf.treasure.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gwf.treasure.DurationParser;
import com.gwf.treasure.app.MapMinutesParser;

public class DurationParserTest {
	private DurationParser durationParser;

	public DurationParserTest() {

	}

	@BeforeAll
	static void initAll() {
	}

	@BeforeEach
	void init() {
		durationParser = new MapMinutesParser();
	}

	@AfterEach
	void tearDown() {
	}

	@AfterAll
	static void tearDownAll() {
	}

	@Test
	void singleMinParse() {
		Assertions.assertEquals(1, durationParser.parseTime("1 min"));
	}

	@Test
	void multiMinParse() {
		Assertions.assertEquals(15, durationParser.parseTime("15 mins"));
	}

	@Test
	void singleHourParse() {
		Assertions.assertEquals(60, durationParser.parseTime("1 hour"));
	}

	@Test
	void multiHourParse() {
		Assertions.assertEquals(300, durationParser.parseTime("5 hours"));
	}

	@Test
	void singleMinSingleHourParse() {
		Assertions.assertEquals(61, durationParser.parseTime("1 hour 1 min"));
	}

	@Test
	void singleMinMultiHourParse() {
		Assertions.assertEquals(121, durationParser.parseTime("2 hours 1 min"));
	}

	@Test
	void multiMinSingleHourParse() {
		Assertions.assertEquals(93, durationParser.parseTime("1 hour 33 mins"));
	}

	@Test
	void multiMinMultiHourParse() {
		Assertions.assertEquals(129, durationParser.parseTime("2 hours 9 mins"));
	}
}
