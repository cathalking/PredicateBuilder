package com.ck.composite;

import org.junit.Test;
import static org.fest.assertions.Assertions.*;

public class LeafTest {

	@Test
	public void toString_GivenColumnAndValueAndOperator_ReturnsAll() {
		
		String expectedColumnName = "ACCOUNT";
		String expectedValue = "someClient";
		String expectedOperator = "=";
		Leaf leaf = new Leaf(expectedColumnName, expectedOperator, expectedValue);
		assertThat(leaf.toString()).isEqualTo(expectedColumnName + expectedOperator + expectedValue);
	}

}
