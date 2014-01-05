package com.ck.wildcards;

import java.util.List;
import java.util.Map;

public interface PatternGrouper {

	Map<String, List<String>> group(List<String> values);
	Map<Pattern, List<String>> groupByPattern(List<String> values);

}
