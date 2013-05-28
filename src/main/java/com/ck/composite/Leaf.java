package com.ck.composite;

public class Leaf implements Node {

	private String columnName;
	private String value;
	private String operator;

	public Leaf(String columnName, String operator, String value) {
		this.columnName = columnName;
		this.value = value;
		this.operator = operator;
	}
	
	public String toString() {
		return columnName + operator + value;
	}

}
