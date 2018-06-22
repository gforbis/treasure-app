package com.gwf.treasure;

public class OriginFactory {
	public EndPoint getStandardOrigin() {
		return new Route();
	}
	
	public EndPoint getPreciseOrigin() {
		return new PreciseRoute();
	}
	
	public EndPoint getImmutableOrigin() {
		return new ImmutableRoute();
	}
}
