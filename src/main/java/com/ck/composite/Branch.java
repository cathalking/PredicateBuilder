package com.ck.composite;

public class Branch implements Node {

	private Node node1;
	private Node node2;
	private String combinator;
	
	public Branch(Node node1, String combinator, Node node2) {
		this.node1 = node1;
		this.node2 = node2;
		this.combinator = combinator;
	}
	
	public String toString() {
		return node1.toString() + " " + combinator + " " + node2.toString();
	}
	

}
