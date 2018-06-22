package com.gwf.treasure.app;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gwf.treasure.DurationParser;

class MapMinutesParser implements DurationParser {
	// Pattern
	private static final Pattern timePattern = Pattern.compile(//
			"(?:(\\d*) hours?)?" + // optional number of hour(s)
					"\\s?" + // optional space separator
					"(?:(?:(\\d*) min)s?)?" // optional number of minute(s)
			, Pattern.CASE_INSENSITIVE);

	public MapMinutesParser() {

	}

	@Override
	public long parseTime(String timeString) {
		Matcher m = timePattern.matcher(timeString);
		if (!m.matches()) {
			throw new IllegalArgumentException("Unrecognized duration format: " + timeString);
		}
		long minutes = 0;
		try {
			if (null != m.group(2)) {
				minutes += Long.parseLong(m.group(2));
			}
			if (null != m.group(1)) {
				minutes += TimeUnit.HOURS.toMinutes(Long.parseLong(m.group(1)));
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid duration: " + timeString);
		}
		return minutes;
	}
}
