package com.ck.wildcards;

import static org.fest.assertions.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static com.ck.wildcards.PatternTest.*;
import static com.ck.wildcards.Pattern.*;

import org.junit.Test;

@SuppressWarnings("serial")
public class PatternGrouperTest {

	List<String> values = new ArrayList<String>() {{
		add(VAL_WITH_NO_WILDCARD);
		add(VAL_WITH_WILDCARD_AT_START);
		add(VAL_WITH_WILDCARD_AT_END);
		add(VAL_WITH_WILDCARD_IN_MIDDLE);
		add(VAL_WITH_WILDCARD_AT_START_AND_END);
	}};
	PatternGrouper patternGrouper = new PatternGrouperImpl();

	@Test
	public void shouldGroupAllPatterns() {
		assertThat(patternGrouper.group(values).keySet()).containsOnly(
				NON_WILDCARD, 
				ONE_WILDCARD_AT_START, 
				ONE_WILDCARD_AT_END, 
				ONE_WILDCARD_IN_MIDDLE, 
				TWO_WILDCARDS_ONE_AT_START_AND_END);
		assertThat(patternGrouper.group(values).get(NON_WILDCARD)).containsOnly(VAL_WITH_NO_WILDCARD);
		assertThat(patternGrouper.group(values).get(ONE_WILDCARD_AT_START)).containsOnly(VAL_WITH_WILDCARD_AT_START);
		assertThat(patternGrouper.group(values).get(ONE_WILDCARD_AT_END)).containsOnly(VAL_WITH_WILDCARD_AT_END);
		assertThat(patternGrouper.group(values).get(ONE_WILDCARD_IN_MIDDLE)).containsOnly(VAL_WITH_WILDCARD_IN_MIDDLE);
		assertThat(patternGrouper.group(values).get(TWO_WILDCARDS_ONE_AT_START_AND_END)).containsOnly(VAL_WITH_WILDCARD_AT_START_AND_END);
	}

	@Test
	public void shouldGroupAllNonWildcardPatterns() {
		assertThat(patternGrouper.group(values).keySet()).contains(NON_WILDCARD);
		assertThat(patternGrouper.group(values).get(NON_WILDCARD)).containsOnly(VAL_WITH_NO_WILDCARD);
	}
	
	@Test
	public void shouldGroupAllOneWildcardAtStartPatterns() {
		assertThat(patternGrouper.group(values).keySet()).contains(ONE_WILDCARD_AT_START);
		assertThat(patternGrouper.group(values).get(ONE_WILDCARD_AT_START)).containsOnly(VAL_WITH_WILDCARD_AT_START);
	}

	@Test
	public void shouldGroupAllOneWildcardAtEndPatterns() {
		assertThat(patternGrouper.group(values).keySet()).contains(ONE_WILDCARD_AT_END);
		assertThat(patternGrouper.group(values).get(ONE_WILDCARD_AT_END)).containsOnly(VAL_WITH_WILDCARD_AT_END);
	}

	@Test
	public void shouldGroupAllOneWildcardInMiddlePatterns() {
		assertThat(patternGrouper.group(values).keySet()).contains(ONE_WILDCARD_IN_MIDDLE);
		assertThat(patternGrouper.group(values).get(ONE_WILDCARD_IN_MIDDLE)).containsOnly(VAL_WITH_WILDCARD_IN_MIDDLE);
	}
	
	@Test
	public void shouldGroupAllTwoWildcardsOneAtStartAndEndPatterns() {
		assertThat(patternGrouper.group(values).keySet()).contains(TWO_WILDCARDS_ONE_AT_START_AND_END);
		assertThat(patternGrouper.group(values).get(TWO_WILDCARDS_ONE_AT_START_AND_END)).containsOnly(VAL_WITH_WILDCARD_AT_START_AND_END);
	}
	
	@Test
	public void shouldGroupAllTwoWildcardsOneAtStartAndEndPatterns_MultipleValues() {
		String val_with_wildcard_at_start_and_end2 = "*val2ue*";
		values.add(val_with_wildcard_at_start_and_end2);
		assertThat(patternGrouper.group(values).keySet()).contains(TWO_WILDCARDS_ONE_AT_START_AND_END);
		assertThat(patternGrouper.group(values).get(TWO_WILDCARDS_ONE_AT_START_AND_END)).
											containsOnly(VAL_WITH_WILDCARD_AT_START_AND_END, val_with_wildcard_at_start_and_end2);
	}

}
