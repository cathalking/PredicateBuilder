package com.ck.wildcards;

import org.apache.commons.lang3.StringUtils;

public class SingleWildcardAtEndPattern implements Pattern {

	public String match(String value) {
		if (value.endsWith(WILDCARD) && StringUtils.countMatches(value, WILDCARD) == 1)
			return value;
		else
			return null;
	}

	@Override
	public String getName() {
		return ONE_WILDCARD_AT_END;
	}

}
