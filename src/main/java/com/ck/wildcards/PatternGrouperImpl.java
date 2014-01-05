package com.ck.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.collections15.CollectionUtils.select;

import org.apache.commons.collections15.Predicate;

public class PatternGrouperImpl implements PatternGrouper {

	Map<Pattern, Predicate<String>> predicatesMap = new HashMap<>();
	
	public PatternGrouperImpl() {
		this(	new NoWildcardPattern(), 
				new SingleWildcardAtStartPattern(),
				new SingleWildcardAtEndPattern(),
				new SingleWildcardInMiddlePattern(),
				new TwoWildcardsOneAtStartAndEndPattern()
		);
	}
	
	public PatternGrouperImpl(Pattern... patterns) {
		for (Pattern pattern : patterns) {
			predicatesMap.put(pattern, predicateWith(pattern));
		}
	}

	@Override
	public Map<Pattern, List<String>> groupByPattern(List<String> values) {
		Map<Pattern, List<String>> groupedValues = new HashMap<>();
		for(Pattern pattern : predicatesMap.keySet()) {
			groupedValues.put(pattern, asList(select(values, predicatesMap.get(pattern))));
		}
		return groupedValues;
	}
	@Override
	public Map<String, List<String>> group(List<String> values) {
		Map<Pattern, List<String>> groupedValues = groupByPattern(values);
		Map<String, List<String>> groupedValuesKeyedByPatternName = new HashMap<>();
		for(Pattern pattern : groupedValues.keySet()) {
			groupedValuesKeyedByPatternName.put(pattern.getName(), groupedValues.get(pattern));
		}
		return groupedValuesKeyedByPatternName;
	}

	private List<String> asList(Collection<String> selected) {
		return new ArrayList<String>(selected);
	}

	private static Predicate<String> predicateWith(final Pattern patternMatcher) {
		return new Predicate<String>() {
			@Override
			public boolean evaluate(String value) {
				return patternMatcher.match(value) != null;
			}
		};
	}

}
