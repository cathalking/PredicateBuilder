package com.ck.wildcards;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class PatternTest {
	public static final String VAL_WITH_NO_WILDCARD = "value";
	public static final String VAL_WITH_WILDCARD_AT_START = "*value";
	public static final String VAL_WITH_WILDCARD_AT_END = "value*";
	public static final String VAL_WITH_WILDCARD_IN_MIDDLE = "val*ue";
	public static final String VAL_WITH_WILDCARD_AT_START_AND_END = "*value*";

	Pattern noWildcardMatcher = new NoWildcardPattern();
	Pattern singleWildcardAtStartMatcher = new SingleWildcardAtStartPattern();
	Pattern singleWildcardAtEndMatcher = new SingleWildcardAtEndPattern();
	Pattern singleWildcardInMiddleMatcher = new SingleWildcardInMiddlePattern();
	Pattern twoWildcardsOneAtStartAndEndMatcher = new TwoWildcardsOneAtStartAndEndPattern();

	@Test
	public void noWildcardMatcher_matchesValueWithNoWildCard() {
		assertThat(noWildcardMatcher.match(VAL_WITH_NO_WILDCARD)).isEqualTo(VAL_WITH_NO_WILDCARD);
	}

	@Test
	public void noWildcardMatcher_doesNotMatchValueWithWildCardAtStart() {
		assertThat(noWildcardMatcher.match(VAL_WITH_WILDCARD_AT_START)).isNull();
		assertThat(noWildcardMatcher.match(VAL_WITH_WILDCARD_AT_END)).isNull();
		assertThat(noWildcardMatcher.match(VAL_WITH_WILDCARD_IN_MIDDLE)).isNull();
		assertThat(noWildcardMatcher.match(VAL_WITH_WILDCARD_AT_START_AND_END)).isNull();
	}
	
	@Test
	public void singleWildcardAtStartMatcher_matchesValueWithWildCardAtStart() {
		assertThat(singleWildcardAtStartMatcher.match(VAL_WITH_WILDCARD_AT_START)).isEqualTo(VAL_WITH_WILDCARD_AT_START);
	}

	@Test
	public void singleWildcardAtStartMatcher_doesNotMatchValueWithAnyOtherPattern() {
		assertThat(singleWildcardAtStartMatcher.match(VAL_WITH_NO_WILDCARD)).isNull();
		assertThat(singleWildcardAtStartMatcher.match(VAL_WITH_WILDCARD_AT_END)).isNull();
		assertThat(singleWildcardAtStartMatcher.match(VAL_WITH_WILDCARD_IN_MIDDLE)).isNull();
		assertThat(singleWildcardAtStartMatcher.match(VAL_WITH_WILDCARD_AT_START_AND_END)).isNull();
	}
	
	@Test
	public void singleWildcardAtEndMatcher_matchesValueWithWildCardAtEnd() {
		assertThat(singleWildcardAtEndMatcher.match(VAL_WITH_WILDCARD_AT_END)).isEqualTo(VAL_WITH_WILDCARD_AT_END);
	}

	@Test
	public void singleWildcardAtEndMatcher_doesNotMatchValueWithAnyOtherPattern() {
		assertThat(singleWildcardAtEndMatcher.match(VAL_WITH_NO_WILDCARD)).isNull();
		assertThat(singleWildcardAtEndMatcher.match(VAL_WITH_WILDCARD_AT_START)).isNull();
		assertThat(singleWildcardAtEndMatcher.match(VAL_WITH_WILDCARD_IN_MIDDLE)).isNull();
		assertThat(singleWildcardAtEndMatcher.match(VAL_WITH_WILDCARD_AT_START_AND_END)).isNull();
	}
	
	@Test
	public void singleWildcardInMiddleMatcher_matchesValueWithWildCardInMiddle() {
		assertThat(singleWildcardInMiddleMatcher.match(VAL_WITH_WILDCARD_IN_MIDDLE)).isEqualTo(VAL_WITH_WILDCARD_IN_MIDDLE);
	}
	
	@Test
	public void singleWildcardInMiddleMatcher_doesNotMatchValueWithAnyOtherPattern() {
		assertThat(singleWildcardInMiddleMatcher.match(VAL_WITH_NO_WILDCARD)).isNull();
		assertThat(singleWildcardInMiddleMatcher.match(VAL_WITH_WILDCARD_AT_START)).isNull();
		assertThat(singleWildcardInMiddleMatcher.match(VAL_WITH_WILDCARD_AT_END)).isNull();
		assertThat(singleWildcardInMiddleMatcher.match(VAL_WITH_WILDCARD_AT_START_AND_END)).isNull();
	}

	@Test
	public void twoWildcardsOneAtStartAndEndMatcher_matchesValueWithWildCardAtStartAndEnd() {
		assertThat(twoWildcardsOneAtStartAndEndMatcher.match(VAL_WITH_WILDCARD_AT_START_AND_END)).isEqualTo(VAL_WITH_WILDCARD_AT_START_AND_END);
	}
	
	@Test
	public void twoWildcardsOneAtStartAndEndMatcher_doesNotMatchValueWithAnyOtherPattern() {
		assertThat(twoWildcardsOneAtStartAndEndMatcher.match(VAL_WITH_NO_WILDCARD)).isNull();
		assertThat(twoWildcardsOneAtStartAndEndMatcher.match(VAL_WITH_WILDCARD_AT_START)).isNull();
		assertThat(twoWildcardsOneAtStartAndEndMatcher.match(VAL_WITH_WILDCARD_AT_END)).isNull();
		assertThat(twoWildcardsOneAtStartAndEndMatcher.match(VAL_WITH_WILDCARD_IN_MIDDLE)).isNull();
	}
}
