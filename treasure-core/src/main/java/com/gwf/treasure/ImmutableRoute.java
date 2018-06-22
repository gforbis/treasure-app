package com.gwf.treasure;

/**
 * <p>
 * ImmutableRoute is an EndPoint that does not rely on mutating state to
 * reach the endpoint. Rather than using an array for storage, 4 discrete
 * fields are used. This increases readability and verbosity.
 * </p>
 * <p>
 * This class is thread-safe.
 * </p>
 * 
 * @author gary_
 *
 */
class ImmutableRoute implements EndPoint {

	private final double north;
	private final double northwest;
	private final double west;
	private final double southwest;

	public ImmutableRoute() {
		this.north = 0.0;
		this.northwest = 0.0;
		this.west = 0.0;
		this.southwest = 0.0;
	}

	private ImmutableRoute(double north, double northwest, double west, double southwest) {
		this.north = north;
		this.northwest = northwest;
		this.west = west;
		this.southwest = southwest;
	}

	@Override
	public double fromOriginX() {
		double x = 0.0;
		x += north * Math.sin(0 * Math.PI / 4);
		x += northwest * Math.sin(1 * Math.PI / 4);
		x += west * Math.sin(2 * Math.PI / 4);
		x += southwest * Math.sin(3 * Math.PI / 4);
		return x;
	}

	@Override
	public double fromOriginY() {
		double y = 0.0;
		y += north * Math.cos(0 * Math.PI / 4);
		y += northwest * Math.cos(1 * Math.PI / 4);
		y += west * Math.cos(2 * Math.PI / 4);
		y += southwest * Math.cos(3 * Math.PI / 4);
		return y;
	}

	@Override
	public EndPoint move(Direction direction, double distance) {
		switch (direction) {
		case N:
			return new ImmutableRoute(north + distance, northwest, west, southwest);
		case NW:
			return new ImmutableRoute(north, northwest + distance, west, southwest);
		case W:
			return new ImmutableRoute(north, northwest, west + distance, southwest);
		case SW:
			return new ImmutableRoute(north, northwest, west, southwest + distance);
		case S:
			return new ImmutableRoute(north - distance, northwest, west, southwest);
		case SE:
			return new ImmutableRoute(north, northwest - distance, west, southwest);
		case E:
			return new ImmutableRoute(north, northwest, west - distance, southwest);
		case NE:
			return new ImmutableRoute(north, northwest, west, southwest - distance);
		}
		throw new IllegalArgumentException("Can never reach unless Direction has been refactored");
	}
}