package com.ck.composite;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class BranchTest {
	
	@Test
	public void toString_GivenTwoLeaves_ShouldReturnBothLeaves() throws Exception {
		
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
		String expectedCombinator = "AND";
		Branch branch = new Branch(leaf1, expectedCombinator, leaf2);
		
		assertThat(branch.toString()).isEqualTo(leaf1Str + " " + expectedCombinator + " " + leaf2Str);
		
	}

	@Test
	public void toString_GivenOneLeafAndOneBranch_ShouldReturnBothLeafAndBranch() throws Exception {
		String expectedColumnName1 = "ACCOUNT";
		String expectedValue1 = "someClient";
		String expectedOperator1 = "=";
		Leaf leaf1 = new Leaf(expectedColumnName1, expectedOperator1, expectedValue1);
		String expectedLeaf1Str = leaf1.toString();
		String expectedCombinator1 = "OR";
		
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
		String expectedCombinator2 = "AND";
		Branch subBranch = new Branch(branch1Leaf1, expectedCombinator2, branch1Leaf2);
		String expectedSubBranchStr = expectedBranch1Leaf1Str 
					+ " " + expectedCombinator2 + " " + expectedBranch1Leaf2Str;
		
		Branch branch = new Branch(leaf1, expectedCombinator1, subBranch);
		assertThat(branch.toString()).isEqualTo(expectedLeaf1Str + " " + expectedCombinator1 + " " + expectedSubBranchStr);
		
	}
}
