package com.gwf.treasure;

import java.util.function.Function;
import java.util.function.LongToDoubleFunction;

class MapStringParser implements MapParser<String> {
	private final String delimiter;
	private final Function<String, LongToDoubleFunction> conveyanceFactory;
	private final DurationParser durationParser;

	public MapStringParser(Function<String, LongToDoubleFunction> cFactory, DurationParser dParser) {
		this(", ", cFactory, dParser);
	}

	public MapStringParser(String delimiter, Function<String, LongToDoubleFunction> cFactory, DurationParser dParser) {
		this.delimiter = delimiter;
		this.conveyanceFactory = cFactory;
		this.durationParser = dParser;
	}

	@Override
	public EndPoint parse(String in, EndPoint origin) {
		EndPoint result = origin;
		if (null == in) {
			throw new NullPointerException("Input is NULL");
		}
		String[] lines = in.split("\\n");
		for (String line : lines) {
			String[] elements = line.split(delimiter);
			LongToDoubleFunction conveyance = conveyanceFactory.apply(elements[0]);
			long minutes = durationParser.parseTime(elements[1]);
			Direction direction = Direction.valueOf(elements[2]);
			result = result.move(direction, conveyance.applyAsDouble(minutes));
		}
		return result;
	}
}
