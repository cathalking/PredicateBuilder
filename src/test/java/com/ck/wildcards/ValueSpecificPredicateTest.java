package com.ck.wildcards;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ValueSpecificPredicateTest {

	@Test
	public void test() {
		String field = "ACCOUNT";
		String operator = " = ";
		String value = "\"value\"";
		
		String predicate = field + operator + value;
	}

}
