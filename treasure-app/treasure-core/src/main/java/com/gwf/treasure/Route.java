package com.gwf.treasure;

/**
 * <p>
 * Route is an EndPoint that presumes movement takes place along an infinite
 * plane. It does not account for real-world considerations such as curvature of
 * the Earth, the limit on North/South movement imposed by the poles, or the
 * ambiguity of direction at the poles.
 * </p>
 * <p>
 * This assumption seems inline with the assigned task, but is noted for
 * completeness.
 * </p>
 * 
 * @author gary_
 *
 */
class Route implements EndPoint {
	/**
	 * <p>
	 * Each element of accumulator corresponds to one of the first half of the
	 * direction ordinals: N, NW, W, and SW. Movements in the opposite directions
	 * are expressed as a negative magnitude.
	 * </p>
	 * <p>
	 * <em>e.g. 13m SE is applied as -13m NW</em>
	 * </p>
	 * <p>
	 * Distances are expressed as whole numbers to prevent floating point rounding
	 * errors from accumulating and throwing off the final result.
	 * </p>
	 */
	private final double[] accumulator = new double[4];

	public Route() {
	}

	@Override
	public double fromOriginX() {
		double x = 0.0;
		for (int n = 0; n < 4; n++) {
			x += accumulator[n] * Math.sin(n * Math.PI / 4);
		}
		return x;
	}

	@Override
	public double fromOriginY() {
		double y = 0.0;
		for (int n = 0; n < 4; n++) {
			y += accumulator[n] * Math.cos(n * Math.PI / 4);
		}
		return y;
	}

	@Override
	public EndPoint move(Direction direction, double distance) {
		if (direction.ordinal() < 4) {
			accumulator[direction.ordinal()] += distance;
		} else {
			accumulator[direction.ordinal() - 4] -= distance;
		}
		return this;
	}
}