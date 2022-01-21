package com.mahendra.demo1.models;

public class Currency {
	private float value;
	private String prefix;

	public Currency(float value, String prefix) {
		super();
		this.value = value;
		this.prefix = prefix;
	}

	@Override
	public String toString() {
		return prefix + " " + value;
	}

}
