package com.ck.wildcards;

import org.apache.commons.lang3.StringUtils;

public class SingleWildcardAtStartPattern implements Pattern {

	public String match(String value) {
		if (value.startsWith(WILDCARD) && StringUtils.countMatches(value, WILDCARD) == 1)
			return value;
		else
			return null;
	}

	@Override
	public String getName() {
		return ONE_WILDCARD_AT_START;
	}

}
