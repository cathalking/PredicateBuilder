package com.ck.wildcards;

import org.apache.commons.lang3.StringUtils;

public class TwoWildcardsOneAtStartAndEndPattern implements Pattern {

	public String match(String value) {
		if (value.startsWith(WILDCARD) && value.endsWith(WILDCARD) && StringUtils.countMatches(value, WILDCARD) == 2)
			return value;
		else
			return null;
	}
	
	@Override
	public String getName() {
		return TWO_WILDCARDS_ONE_AT_START_AND_END;
	}

}
