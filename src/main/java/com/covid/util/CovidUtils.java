package com.covid.util;

public class CovidUtils {

	
	@SuppressWarnings("unchecked")
	public static<FROM, TO> TO cast(FROM in) {
		return (TO) in;
	}
	
}
