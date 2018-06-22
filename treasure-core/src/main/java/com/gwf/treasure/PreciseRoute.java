package com.gwf.treasure;

import java.math.BigDecimal;

/**
 * <p>
 * PreciseRoute is an alternative to Route with increased precision. This level
 * of precision is overkill unless processing maps with a very large set of
 * movements.
 * </p>
 * 
 * @author gary_
 *
 */
class PreciseRoute implements EndPoint {
	private final BigDecimal[] accumulator = new BigDecimal[4];

	public PreciseRoute() {
		for (int n = 0; n < 4; n++) {
			accumulator[n] = BigDecimal.ZERO;
		}
	}

	@Override
	public EndPoint move(Direction direction, double distance) {
		if (direction.ordinal() < 4) {
			accumulator[direction.ordinal()] = accumulator[direction.ordinal()].add(BigDecimal.valueOf(distance));
		} else {
			accumulator[direction.ordinal() - 4] = accumulator[direction.ordinal() - 4]
					.subtract(BigDecimal.valueOf(distance));
		}
		return this;
	}

	@Override
	public double fromOriginX() {
		BigDecimal x = BigDecimal.ZERO;
		for (int n = 0; n < 4; n++) {
			x = x.add(accumulator[n].multiply(BigDecimal.valueOf(Math.sin(n * Math.PI / 4))));
		}
		return x.doubleValue();
	}

	@Override
	public double fromOriginY() {
		BigDecimal y = BigDecimal.ZERO;
		for (int n = 0; n < 4; n++) {
			y = y.add(accumulator[n].multiply(BigDecimal.valueOf(Math.cos(n * Math.PI / 4))));
		}
		return y.doubleValue();
	}
}
