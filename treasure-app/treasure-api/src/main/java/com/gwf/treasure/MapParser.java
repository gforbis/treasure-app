package com.gwf.treasure;

public interface MapParser<T> {
	EndPoint parse(T in, EndPoint origin);
}
