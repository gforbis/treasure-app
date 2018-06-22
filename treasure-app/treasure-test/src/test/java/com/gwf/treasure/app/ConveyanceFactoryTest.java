package com.gwf.treasure.app;

import java.util.function.Function;
import java.util.function.LongToDoubleFunction;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gwf.treasure.DurationParser;
import com.gwf.treasure.app.ConveyanceFactory;
import com.gwf.treasure.app.MapMinutesParser;

public class ConveyanceFactoryTest {
	private DurationParser durationParser;
	private Function<String, LongToDoubleFunction> conveyanceFactory;

	public ConveyanceFactoryTest() {

	}

	@BeforeAll
	static void initAll() {
	}

	@BeforeEach
	void init() {
		durationParser = new MapMinutesParser();
		conveyanceFactory = new ConveyanceFactory();
	}

	@Test
	void succeedingTest() {
	}

	@Test
	void oneMinWalk() {
		// 3 MPH to minutes = 3 / 60
		double miles = 0.05;
		Assertions.assertEquals(miles, conveyanceFactory.apply("walk").applyAsDouble(1));
	}

	@Test
	void oneHourWalk() {
		double miles = 3;
		Assertions.assertEquals(miles, conveyanceFactory.apply("walk").applyAsDouble(60));
	}

	@AfterEach
	void tearDown() {
	}

	@AfterAll
	static void tearDownAll() {
	}

}
