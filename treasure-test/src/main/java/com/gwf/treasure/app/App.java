package com.gwf.treasure.app;
import java.io.File;
import java.util.function.Function;

import com.gwf.treasure.EndPoint;
import com.gwf.treasure.EndPointFormatterFactory;
import com.gwf.treasure.MapParser;
import com.gwf.treasure.MapParserFactory;
import com.gwf.treasure.OriginFactory;


public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String filename = null;
		int precision = 1;
		for (int n = 0; n < args.length; n++) {
			if ("-?".equals(args[n])) {
				printHelp();
				return;
			}
			if ("-f".equals(args[n]) && n + 1 < args.length) {
				filename = args[++n];
			}
			if ("-p".equals(args[n]) && n + 1 < args.length) {
				precision = Integer.parseInt(args[++n]);
			}
		}
		if (null == filename) {
			System.out.println("Missing argument: -f filename");
			return;
		}
		File mapFile = new File(filename);		
		EndPoint result = findEndPoint(mapFile);
		Function<EndPoint, String> formatter = EndPointFormatterFactory.getTextFormatter(precision);
		System.out.println("----> RESULT: " + formatter.apply(result));
	}
	
    private static void printHelp() {
		System.out.println("Usage: TreasureFinder -f filepath [-p precision]");
	}
    
    private static EndPoint findEndPoint(File mapFile) {
		MapParser<File> mapParser = MapParserFactory.getFileParser(new ConveyanceFactory(), new MapMinutesParser());
		return mapParser.parse(mapFile, new OriginFactory().getStandardOrigin());
    }
}