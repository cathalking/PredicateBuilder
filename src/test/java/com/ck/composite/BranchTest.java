package com.ck.composite;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class BranchTest {
	
	@Test
	public void toString_GivenTwoLeaves_ShouldReturnBothLeaves() throws Exception {
		Leaf leaf1 = new Leaf("ACCOUNT", "=", "someClient");
		Leaf leaf2 = new Leaf("ORDERID", "=", "123");
		Branch branch = new Branch(leaf1, "AND", leaf2);
		
		assertThat(branch.toString()).isEqualTo("ACCOUNT=someClient AND ORDERID=123");
	}

	@Test
	public void toString_GivenOneLeafAndOneBranch_ShouldReturnBothLeafAndBranch() throws Exception {
		Leaf leaf1 = new Leaf("ACCOUNT", "=", "someClient");
		Leaf branch1Leaf1 = new Leaf("START_TIME", ">=", "10:00AM");
		Leaf branch1Leaf2 = new Leaf("END_TIME", "<=", "11:00AM");
		Branch subBranch = new Branch(branch1Leaf1, "AND", branch1Leaf2);
		Branch branch = new Branch(leaf1, "OR", subBranch);

		assertThat(branch.toString()).isEqualTo("ACCOUNT=someClient OR (START_TIME>=10:00AM AND END_TIME<=11:00AM)");
	}
}
