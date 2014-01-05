package com.ck.wildcards;

public class NoWildcardPattern implements Pattern {

	public String match(String value) {
		if (value.contains(WILDCARD))
			return null;
		else
			return value;
	}

	@Override
	public String getName() {
		return NON_WILDCARD;
	}
	
}
