package com.narratage.util;

public class StringUtils {
	public static String replace(String original, String pattern, String replace) {
		int s = 0;
		int e = 0;
		StringBuffer buffer = new StringBuffer();

		while ((e = original.indexOf(pattern, s)) >= 0) {
			buffer.append(original.substring(s, e));
			buffer.append(replace);
			s = e + pattern.length();
		}
		buffer.append(original.substring(s));

		return buffer.toString();
	}

}
