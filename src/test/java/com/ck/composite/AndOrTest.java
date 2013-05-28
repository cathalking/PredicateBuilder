package com.ck.composite;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class AndOrTest {
	
	@Test
	public void toString_GivenTwoLeaves_ShouldReturnBothLeavesWithAND() throws Exception {
		
		String expectedColumnName1 = "ACCOUNT";
		String expectedValue1 = "someClient";
		String expectedOperator1 = "=";
		Leaf leaf1 = new Leaf(expectedColumnName1, expectedValue1, expectedOperator1);
		String leaf1Str = leaf1.toString();
		
		String expectedColumnName2 = "ORDERID";
		String expectedValue2 = "123";
		String expectedOperator2 = "=";
		Leaf leaf2 = new Leaf(expectedColumnName2, expectedValue2, expectedOperator2);
		String leaf2Str = leaf2.toString();
		And and = new And(leaf1, leaf2);
		
		assertThat(and.toString()).isEqualTo(leaf1Str + " AND " + leaf2Str);
		
	}

	@Test
	public void toString_GivenOneLeafAndOneBranch_ShouldReturnBothLeafAndBranch() throws Exception {
		String expectedColumnName1 = "ACCOUNT";
		String expectedValue1 = "someClient";
		String expectedOperator1 = "=";
		Leaf leaf1 = new Leaf(expectedColumnName1, expectedOperator1, expectedValue1);
		String expectedLeaf1Str = leaf1.toString();
		
		String expectedColumnName2 = "START_TIME";
		String expectedValue2 = "10:00AM";
		String expectedOperator2 = ">=";
		Leaf branch1Leaf1 = new Leaf(expectedColumnName2, expectedOperator2, expectedValue2);
		String expectedBranch1Leaf1Str = branch1Leaf1.toString();
		
		String expectedColumnName3 = "END_TIME";
		String expectedValue3 = "11:00AM";
		String expectedOperator3 = "<=";
		Leaf branch1Leaf2 = new Leaf(expectedColumnName3, expectedOperator3, expectedValue3);
		String expectedBranch1Leaf2Str = branch1Leaf2.toString();
		And subBranch = new And(branch1Leaf1, branch1Leaf2);
		String expectedSubBranchStr = expectedBranch1Leaf1Str 
					+ " AND " + expectedBranch1Leaf2Str;
		
		Or branch = new Or(leaf1, subBranch);
		assertThat(branch.toString()).isEqualTo(expectedLeaf1Str + " OR " + expectedSubBranchStr);
		
	}
}
