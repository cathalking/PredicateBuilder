package com.ck.composite;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class AndOrTest {
	
	@Test
	public void toString_GivenTwoLeaves_ShouldReturnBothLeavesWithAND() throws Exception {
		Leaf leaf1 = new Leaf("ACCOUNT", "=", "someClient");
		Leaf leaf2 = new Leaf("ORDERID", "=", "123");
		And and = new And(leaf1, leaf2);
		
		assertThat(and.toString()).isEqualTo("ACCOUNT=someClient AND ORDERID=123");
	}

	@Test
	public void toString_GivenOneLeafAndOneBranch_ShouldReturnBothLeafAndBranch() throws Exception {
		Leaf leaf1 = new Leaf("ACCOUNT", "=", "someClient");
		Leaf branch1Leaf1 = new Leaf("START_TIME", ">=", "10:00AM");
		Leaf branch1Leaf2 = new Leaf("END_TIME", "<=", "11:00AM");
		And subBranch = new And(branch1Leaf1, branch1Leaf2);
		Or branch = new Or(leaf1, subBranch);

		assertThat(branch.toString()).isEqualTo("ACCOUNT=someClient OR (START_TIME>=10:00AM AND END_TIME<=11:00AM)");
	}
}
