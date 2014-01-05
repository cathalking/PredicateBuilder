package com.ck.wildcards;

public interface Pattern {

	public static final String NON_WILDCARD = "NON_WILDCARD";
	public static final String ONE_WILDCARD_AT_START = "ONE_WILDCARD_AT_START";
	public static final String ONE_WILDCARD_AT_END = "ONE_WILDCARD_AT_END";
	public static final String ONE_WILDCARD_IN_MIDDLE = "ONE_WILDCARD_IN_MIDDLE";
	public static final String TWO_WILDCARDS_ONE_AT_START_AND_END = "TWO_WILDCARDS_ONE_AT_START_AND_END";
	public static final String WILDCARD = "*";
	String match(String value);
	String getName();

}
