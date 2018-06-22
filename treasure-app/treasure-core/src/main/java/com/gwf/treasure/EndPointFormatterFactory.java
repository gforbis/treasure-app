package com.gwf.treasure;

import java.util.function.Function;

public class EndPointFormatterFactory {
	private EndPointFormatterFactory() {
		throw new UnsupportedOperationException();
	}

	public static Function<EndPoint, String> getTextFormatter(int precision) {
		DoubleToStringFunction format = n -> String.format("%1." + precision + "f", n);
		return e -> {
			double x = e.fromOriginX();
			double y = e.fromOriginY();
			StringBuilder sb = new StringBuilder();
			sb.append(format.apply(Math.abs(y)));
			sb.append(" miles to the ");
			sb.append(y >= 0 ? "north" : "south");
			sb.append(", ");
			sb.append(format.apply(Math.abs(x)));
			sb.append(" miles to the ");
			sb.append(x >= 0 ? "west" : "east");
			return sb.toString();
		};
	}

	public static Function<EndPoint, String> getHtmlFormatter(int precision, String units) {
		DoubleToStringFunction format = n -> String.format("%1." + precision + "f", n);
		return e -> {
			double x = e.fromOriginX();
			double y = e.fromOriginY();
			StringBuilder sb = new StringBuilder();
			sb.append("<table>\n");
			sb.append("  <tr>\n");
			sb.append("    <th></th>\n");
			sb.append("    <th>");
			sb.append(y >= 0 ? "North" : "South");
			sb.append("    </th>\n");
			sb.append("    <th>");
			sb.append(x >= 0 ? "West" : "East");
			sb.append("    </th>\n");
			sb.append("  </tr>\n");
			sb.append("  <tr>\n");
			sb.append("    <td>");
			sb.append(units);
			sb.append("    </td>\n");
			sb.append("    <td>");
			sb.append(format.apply(Math.abs(y)));
			sb.append("    </td>\n");
			sb.append("    <td>");
			sb.append(format.apply(Math.abs(x)));
			sb.append("    </td>\n");
			sb.append("  </tr>\n");
			sb.append("</table>");
			return sb.toString();
		};
	}
}
