package com.gwf.treasure.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gwf.treasure.EndPoint;
import com.gwf.treasure.MapParser;
import com.gwf.treasure.MapParserFactory;
import com.gwf.treasure.OriginFactory;
import com.gwf.treasure.app.ConveyanceFactory;
import com.gwf.treasure.app.MapMinutesParser;

public class MapParserTest {
	private static OriginFactory originFactory;
	private static String mockMap;
	private MapParser<String> stringParser;

	public MapParserTest() {

	}

	@BeforeAll
	static void initAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("Walk, 20 mins, N\n");
		sb.append("Run, 1 hour, E\n");
		sb.append("Horse trot, 3 hours, NW\n");
		sb.append("Elephant ride, 1 hour 30 mins, SE\n");
		sb.append("Horse gallop, 20 mins, SE\n");
		sb.append("Walk, 30 mins, SW\n");
		sb.append("Horse trot, 1 hour 1 min, W\n");
		MapParserTest.mockMap = sb.toString();
		MapParserTest.originFactory = new OriginFactory();
	}

	@BeforeEach
	void init() {
		stringParser = MapParserFactory.getStringParser(new ConveyanceFactory(), new MapMinutesParser());
	}

	@AfterEach
	void tearDown() {
	}

	@AfterAll
	static void tearDownAll() {
	}

	@Test
	void fullTest() {
		EndPoint ep = stringParser.parse(mockMap, originFactory.getStandardOrigin());
		Assertions.assertNotNull(ep);
	}
}
