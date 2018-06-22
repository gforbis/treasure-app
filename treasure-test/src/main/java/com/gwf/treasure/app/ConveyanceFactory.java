package com.gwf.treasure.app;

import java.util.function.Function;
import java.util.function.LongToDoubleFunction;

class ConveyanceFactory implements Function<String, LongToDoubleFunction> {
	@Override
	public LongToDoubleFunction apply(String conveyance) {
		if ("Walk".equalsIgnoreCase(conveyance)) {
			return n -> (double) n * 3 / 60;
		}
		if ("Run".equalsIgnoreCase(conveyance)) {
			return n -> (double) n * 6 / 60;
		}
		if ("Horse trot".equalsIgnoreCase(conveyance)) {
			return n -> (double) n * 4 / 60;
		}
		if ("Horse gallop".equalsIgnoreCase(conveyance)) {
			return n -> (double) n * 15 / 60;
		}
		if ("Elephant ride".equalsIgnoreCase(conveyance)) {
			return n -> (double) n * 6 / 60;
		}
		if ("Drive".equalsIgnoreCase(conveyance)) {
			return n -> (double) n * 60 / 60;
		}
		throw new IllegalArgumentException("Unrecognized conveyance: " + conveyance);
	}

}
