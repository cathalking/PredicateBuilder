package com.ck.composite;

import org.junit.Test;
import static org.fest.assertions.Assertions.*;

public class LeafTest {

	@Test
	public void toString_GivenColumnAndValueAndOperator_ReturnsAll() {
		Leaf leaf = new Leaf("ACCOUNT", "=", "someClient");
		assertThat(leaf.toString()).isEqualTo("ACCOUNT=someClient");
	}

}
