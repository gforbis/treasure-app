package com.gwf.treasure.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gwf.treasure.Direction;
import com.gwf.treasure.EndPoint;
import com.gwf.treasure.OriginFactory;

public class EndPointTest {
	private static OriginFactory originFactory;
	private EndPoint[] endPoints;

	public EndPointTest() {

	}

	@BeforeAll
	static void initAll() {
		EndPointTest.originFactory = new OriginFactory();
	}

	@BeforeEach
	void init() {
		endPoints = new EndPoint[3];
		endPoints[0] = originFactory.getStandardOrigin();
		endPoints[1] = originFactory.getPreciseOrigin();
		endPoints[2] = originFactory.getImmutableOrigin();
	}

	@AfterEach
	void tearDown() {
	}

	@AfterAll
	static void tearDownAll() {
	}

	@Test
	void testStandardOrigin() {
		EndPoint ep = originFactory.getStandardOrigin();
		Assertions.assertEquals(0.0, ep.fromOriginX(), 0.00001);
		Assertions.assertEquals(0.0, ep.fromOriginY(), 0.00001);
	}

	@Test
	void testPreciseOrigin() {
		EndPoint ep = originFactory.getPreciseOrigin();
		Assertions.assertEquals(0.0, ep.fromOriginX(), 0.000000001);
		Assertions.assertEquals(0.0, ep.fromOriginY(), 0.000000001);
	}

	@Test
	void testImmutableOrigin() {
		EndPoint ep = originFactory.getImmutableOrigin();
		Assertions.assertEquals(0.0, ep.fromOriginX(), 0.00001);
		Assertions.assertEquals(0.0, ep.fromOriginY(), 0.00001);
	}

	@Test
	void testStandardNorthSixty() {
		EndPoint ep = originFactory.getStandardOrigin();
		ep = ep.move(Direction.N, 60);
		Assertions.assertEquals(0.0, ep.fromOriginX(), 0.00001);
		Assertions.assertEquals(60.0, ep.fromOriginY(), 0.00001);
	}

	@Test
	void testPreciseNorthSixty() {
		EndPoint ep = originFactory.getPreciseOrigin();
		ep = ep.move(Direction.N, 60);
		Assertions.assertEquals(0.0, ep.fromOriginX(), 0.000000001);
		Assertions.assertEquals(60.0, ep.fromOriginY(), 0.000000001);
	}

	@Test
	void testImmutableNorthSixty() {
		EndPoint ep = originFactory.getImmutableOrigin();
		ep = ep.move(Direction.N, 60);
		Assertions.assertEquals(0.0, ep.fromOriginX(), 0.00001);
		Assertions.assertEquals(60.0, ep.fromOriginY(), 0.00001);
	}

	@Test
	void testStandardEastSixty() {
		EndPoint ep = originFactory.getStandardOrigin();
		ep = ep.move(Direction.E, 60);
		Assertions.assertEquals(-60, ep.fromOriginX(), 0.00001);
		Assertions.assertEquals(0.0, ep.fromOriginY(), 0.00001);
	}

	@Test
	void testPreciseEastSixty() {
		EndPoint ep = originFactory.getPreciseOrigin();
		ep = ep.move(Direction.E, 60);
		Assertions.assertEquals(-60, ep.fromOriginX(), 0.000000001);
		Assertions.assertEquals(0.0, ep.fromOriginY(), 0.000000001);
	}

	@Test
	void testImmutableEastSixty() {
		EndPoint ep = originFactory.getImmutableOrigin();
		ep = ep.move(Direction.E, 60);
		Assertions.assertEquals(-60, ep.fromOriginX(), 0.00001);
		Assertions.assertEquals(0.0, ep.fromOriginY(), 0.00001);
	}

	@Test
	void testStandardCompositeMove() {
		EndPoint ep = originFactory.getStandardOrigin();
		ep = ep.move(Direction.E, 60);
		ep = ep.move(Direction.N, 60);
		Assertions.assertEquals(-60, ep.fromOriginX(), 0.00001);
		Assertions.assertEquals(60, ep.fromOriginY(), 0.00001);
	}

	@Test
	void testPreciseCompositeMove() {
		EndPoint ep = originFactory.getPreciseOrigin();
		ep = ep.move(Direction.E, 60);
		ep = ep.move(Direction.N, 60);
		Assertions.assertEquals(-60, ep.fromOriginX(), 0.000000001);
		Assertions.assertEquals(60, ep.fromOriginY(), 0.000000001);
	}

	@Test
	void testImmutableCompositeMove() {
		EndPoint ep = originFactory.getImmutableOrigin();
		ep = ep.move(Direction.E, 60);
		ep = ep.move(Direction.N, 60);
		Assertions.assertEquals(-60, ep.fromOriginX(), 0.00001);
		Assertions.assertEquals(60, ep.fromOriginY(), 0.00001);
	}

	@Test
	void testStandardDiagonalMove() {
		EndPoint ep = originFactory.getStandardOrigin();
		ep = ep.move(Direction.NW, 60);
		Assertions.assertEquals(42.42640687119285, ep.fromOriginX(), 0.00001);
		Assertions.assertEquals(42.42640687119285, ep.fromOriginY(), 0.00001);
	}

	@Test
	void testPreciseDiagonalMove() {
		EndPoint ep = originFactory.getPreciseOrigin();
		ep = ep.move(Direction.NW, 60);
		Assertions.assertEquals(42.42640687119285, ep.fromOriginX(), 0.000000001);
		Assertions.assertEquals(42.42640687119285, ep.fromOriginY(), 0.000000001);
	}

	@Test
	void testImmutableDiagonalMove() {
		EndPoint ep = originFactory.getImmutableOrigin();
		ep = ep.move(Direction.NW, 60);
		Assertions.assertEquals(42.42640687119285, ep.fromOriginX(), 0.00001);
		Assertions.assertEquals(42.42640687119285, ep.fromOriginY(), 0.00001);
	}
}
