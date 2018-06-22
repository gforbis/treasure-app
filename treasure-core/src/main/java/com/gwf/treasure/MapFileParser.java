package com.gwf.treasure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;
import java.util.function.LongToDoubleFunction;

class MapFileParser implements MapParser<File> {
	private final String delimiter;
	private final Function<String, LongToDoubleFunction> conveyanceFactory;
	private final DurationParser durationParser;

	public MapFileParser(Function<String, LongToDoubleFunction> conveyanceFactory, DurationParser durationParser) {
		this(", ", conveyanceFactory, durationParser);
	}

	public MapFileParser(String delimiter, Function<String, LongToDoubleFunction> conveyanceFactory,
			DurationParser durationParser) {
		this.delimiter = delimiter;
		this.conveyanceFactory = conveyanceFactory;
		this.durationParser = durationParser;
	}

	@Override
	public EndPoint parse(File mapFile, EndPoint endPoint) {
		EndPoint result = endPoint;
		if (null == mapFile) {
			throw new NullPointerException("File is NULL");
		}
		try (BufferedReader reader = new BufferedReader(new FileReader(mapFile))) {
			String line = reader.readLine();
			while (null != line) {
				String[] elements = line.split(delimiter);
				LongToDoubleFunction conveyance = conveyanceFactory.apply(elements[0]);
				long minutes = durationParser.parseTime(elements[1]);
				Direction direction = Direction.valueOf(elements[2]);
				result = result.move(direction, conveyance.applyAsDouble(minutes));
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File '" + mapFile + "' is missing", e);
		} catch (IOException e) {
			throw new RuntimeException("Unable to process file: " + mapFile, e);
		}
		return result;
	}
}