package com.gwf.treasure;

import java.io.File;
import java.util.function.Function;
import java.util.function.LongToDoubleFunction;

public class MapParserFactory {
	private MapParserFactory() {
		throw new UnsupportedOperationException();
	}

	public static MapParser<File> getFileParser(Function<String, LongToDoubleFunction> conveyanceFactory,
			DurationParser tParser) {
		return new MapFileParser(conveyanceFactory, tParser);
	}

	public static MapParser<String> getStringParser(Function<String, LongToDoubleFunction> conveyanceFactory,
			DurationParser tParser) {
		return new MapStringParser(conveyanceFactory, tParser);
	}
}
