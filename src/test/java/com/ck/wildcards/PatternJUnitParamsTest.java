package com.ck.wildcards;

import static org.fest.assertions.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class PatternJUnitParamsTest {
	public static final String VAL_WITH_NO_WILDCARD = "value";
	public static final String VAL_WITH_WILDCARD_AT_START = "*value";
	public static final String VAL_WITH_WILDCARD_AT_END = "value*";
	public static final String VAL_WITH_WILDCARD_IN_MIDDLE = "val*ue";
	public static final String VAL_WITH_WILDCARD_AT_START_AND_END = "*value*";

	@Parameters
	@Test
	public void matcher_matchesExpectedValue(Pattern pattern, String input) {
		assertThat(pattern.match(input)).isEqualTo(input);
	}
	
	private Object[] parametersForMatcher_matchesExpectedValue() {
		return $(
				$(new NoWildcardPattern(), VAL_WITH_NO_WILDCARD),
				$(new SingleWildcardAtStartPattern(), VAL_WITH_WILDCARD_AT_START),
				$(new SingleWildcardAtEndPattern(), VAL_WITH_WILDCARD_AT_END),
				$(new SingleWildcardInMiddlePattern(), VAL_WITH_WILDCARD_IN_MIDDLE),
				$(new TwoWildcardsOneAtStartAndEndPattern(), VAL_WITH_WILDCARD_AT_START_AND_END)
				);
	}
	
	@Parameters
	@Test
	public void matcher_doesNotMatchesOtherValues(Pattern pattern, String input) {
		assertThat(pattern.match(input)).isNull();
	}

	private Object[] parametersForMatcher_doesNotMatchesOtherValues() {
		return toArray($(
				$(new NoWildcardPattern(), $(VAL_WITH_WILDCARD_AT_START,
											VAL_WITH_WILDCARD_AT_END,
											VAL_WITH_WILDCARD_IN_MIDDLE,
											VAL_WITH_WILDCARD_AT_START_AND_END)),
				$(new SingleWildcardAtStartPattern(), $(VAL_WITH_NO_WILDCARD,
											VAL_WITH_WILDCARD_AT_END,
											VAL_WITH_WILDCARD_IN_MIDDLE,
											VAL_WITH_WILDCARD_AT_START_AND_END)),
				$(new SingleWildcardAtEndPattern(), $(VAL_WITH_NO_WILDCARD,
											VAL_WITH_WILDCARD_AT_START,
											VAL_WITH_WILDCARD_IN_MIDDLE,
											VAL_WITH_WILDCARD_AT_START_AND_END)),
				$(new SingleWildcardInMiddlePattern(), $(VAL_WITH_NO_WILDCARD,
											VAL_WITH_WILDCARD_AT_START,
											VAL_WITH_WILDCARD_AT_END,
											VAL_WITH_WILDCARD_AT_START_AND_END)),
				$(new TwoWildcardsOneAtStartAndEndPattern(), $(VAL_WITH_NO_WILDCARD,
											VAL_WITH_WILDCARD_AT_START,
											VAL_WITH_WILDCARD_AT_END,
											VAL_WITH_WILDCARD_IN_MIDDLE))
				));
	}
	
	private Object[] toArray(Object[] paramsMap) {
		List<Object[]> paramsList = new ArrayList<>();
		for (int i = 0; i < paramsMap.length; i++) {
			Object[] paramsPair = (Object[])paramsMap[i];
			Object param1 = paramsPair[0];
			Object[] params2Array = (Object[])paramsPair[1];
			for (int j = 0; j < params2Array.length; j++) {
				paramsList.add(new Object[] {param1, params2Array[j]} );
			}
		}
		return paramsList.toArray(new Object[0]);
	}

}
